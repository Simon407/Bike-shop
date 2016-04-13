package com.springapp.mvc.services;

import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.info.CartInfo;
import com.springapp.mvc.repositories.hibernate.CartRepositoryHibernate;
import com.springapp.mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public void addCart(Cart cart) {
        cartRepository.add(cart);
    }


//    /**
//     * Добавление товара в корзину
//     */
//    public void addInCart(HttpSession session, Long goodId, Integer count) {
//        List<Cart> carts = (List<Cart>) session.getAttribute(Constants.SESSION_CART_2);
//        if (carts == null) {
//            carts = new ArrayList<Cart>();
//        }
//        if (cart.getGoodId() == null) {
//            cart.setGoodId( goodsService.getGoodsById(goodId));
//            cart.setNumber(count);
//        } else {
//            if (cart.getGoods().containsKey(goodId)) {
//                cart.getGoods().put(goodId, cart.getGoods().get(goodId) + count);
//            } else {
//                cart.getGoods().put(goodId, count);
//            }
//        }
//        session.setAttribute(Constants.SESSION_CART, cart);
//    }

    public void addInCart(HttpSession session, Long goodId, Integer count) {
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

    public void deleteFromCart(HttpSession session, Long goodId) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart != null && cart.getGoods() != null && cart.getGoods().containsKey(goodId)) {
            cart.getGoods().remove(goodId);
        }
        session.setAttribute(Constants.SESSION_CART, cart);
    }
}
