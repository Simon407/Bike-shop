package com.springapp.mvc.services;

import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.info.CartInfo;
import com.springapp.mvc.repositories.hibernate.CartRepositoryHibernate;
import com.springapp.mvc.security.MyUserDetail;
import com.springapp.mvc.security.MyUserDetailService;
import com.springapp.mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private CartRepositoryHibernate cartRepository;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private MyUserDetailService userDetailService;

    @Transactional
    private void addCart(Cart cart) {
        cartRepository.add(cart);
    }

    @Transactional
    private void deleteCartByGoodsId(Long goodId) {
        cartRepository.deleteCartByGoodsId(goodId);
    }

    @Transactional
    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    @Transactional
    private void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    /*
    * Изменение количества товаров
    * перед добавление нового, удаляются старые
    */
    public void changeNumberProduct(HttpSession session, Long goodId, Integer count) {
        String username = getAut();
        if (!username.equals("anonymousUser")) {
            MyUserDetail m = (MyUserDetail) userDetailService.loadUserByUsername(username);
            List<Cart> list = getCartsByUserId(m.getUser().getId());
            Cart c = new Cart(goodsService.getGoodsById(goodId), count, m.getUser());
            deleteCartByGoodsId(goodId);
            addCart(c);
        } else {
            deleteForNotLoginUser(session, goodId);
            addForNotLoginUser(session, goodId, count);
        }
    }

    private List<Cart> getCartsByUserId(Long userId) {
        List<Cart> carts = new ArrayList<Cart>();
        for (Cart c : getAllCarts()) {
            if (c.getUserId().getId().equals(userId)) {
                carts.add(c);
            }
        }
        return carts;
    }

    /*
    * Возвращает нулл потому что для не залогиненных юзеров данные достаются из сессии
    */
    public List<Cart> getCartsByUsername() {
        String username = getAut();
        if (!username.equals("anonymousUser")) {
            MyUserDetail m = (MyUserDetail) userDetailService.loadUserByUsername(username);
            return getCartsByUserId(m.getUser().getId());
        } else return null;
    }

    /**
     * Добавление товара в корзину
     * сначала проверка на авторизацию, если не авторизован то просто в сессию сохранение
     * если авторизован то сохрание в бд
     */
    public void addInCart(HttpSession session, Long goodId, Integer count) {
        String username = getAut();
        if (!username.equals("anonymousUser")) {
            MyUserDetail m = (MyUserDetail) userDetailService.loadUserByUsername(username);
            List<Cart> list = getCartsByUserId(m.getUser().getId());
            if (!containsCart(list, goodId, m.getUser())) {
                Cart c = new Cart(goodsService.getGoodsById(goodId), count, m.getUser());
                addCart(c);
            }
        } else addForNotLoginUser(session, goodId, count);
    }

    public void deleteFromCart(HttpSession session, Long goodId) {
        String username = getAut();
        if (!username.equals("anonymousUser")) {
            MyUserDetail m = (MyUserDetail) userDetailService.loadUserByUsername(username);
            List<Cart> carts = getCartsByUserId(m.getUser().getId());
            for (Cart c : carts) {
                if (c.getGoodId().getId().equals(goodId) && c.getUserId().equals(m.getUser())) {
                    deleteCart(c);
                }
            }
        } else deleteForNotLoginUser(session, goodId);
    }

    public void addForNotLoginUser(HttpSession session, Long goodId, Integer count) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart == null) {
            cart = new CartInfo();
        }
        if (cart.getGoods() == null) {
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            map.put(goodId, count);
            cart.setGoods(map);
        } else {
            if (cart.getGoods().containsKey(goodId)) {
                cart.getGoods().put(goodId, cart.getGoods().get(goodId) + count);
            } else {
                cart.getGoods().put(goodId, count);
            }
        }
        session.setAttribute(Constants.SESSION_CART, cart);
    }

    public void deleteForNotLoginUser(HttpSession session, Long goodId) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart.getGoods() != null && cart.getGoods().containsKey(goodId)) {
            cart.getGoods().remove(goodId);
        }
        session.setAttribute(Constants.SESSION_CART, cart);
    }

    /*
    * Используется когда пользователь сначала добавил товары в корзину а потом залогинился
    * тогда все его товары попадают в бд
    * если товар с таким айди уже есть в бд то количество не меняется
    */
    public void transfer(HttpSession session) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        String username = getAut();
        if (cart != null && !username.equals("anonymousUser")) {
            Map<Long, Integer> mapa = cart.getGoods();
            if (mapa != null) {
                for (Long l : mapa.keySet()) {
                    addInCart(null, l, mapa.get(l));
                }
            }
            session.setAttribute(Constants.SESSION_CART, null);
        }
    }

    private boolean containsCart(List<Cart> carts, Long goodId, User user) {
        boolean result = false;
        for (Cart c : carts) {
            if (c.getGoodId().getId().equals(goodId)) {
                if (user == null || c.getUserId().equals(user)) {
                    result = true;
                }
            }
        }
        return result;
    }

    private String getAut() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
