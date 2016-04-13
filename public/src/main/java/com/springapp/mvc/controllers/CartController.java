package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryMenu;
import com.springapp.mvc.entity.Address;
import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Контроллер для работы с корзиной
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    public static final BigDecimal DELIVERY_CHARGES = new BigDecimal(150);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CartService cartService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;


    /**
     * Отображение содержимого корзины
     * При авторизации переносится вся корзина из сесии в бд
     */
    @IncludeCategoryMenu
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        cartService.transfer(request.getSession());
        request.setAttribute("goods", goodsService.getAllGoods());
        List<Cart> list = cartService.getCartsByUsername();
        if (list != null) {
            request.setAttribute("carts", list);
        }
        if (list != null) {
            request.setAttribute("cartsSize", new Integer(list.size()));
        }
        return "cart";
    }

    /**
     * Добавление продукта в корзину
     *
     * @param id
     */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestParam Long id) {
        cartService.addInCart(request.getSession(), id, 1);
    }

    /**
     * Изменение количества товаров в корзине
     *
     * @param id
     * @param number
     */
    @RequestMapping(value = "/changeNumberProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeNumberProduct(@RequestParam("id") Long id, @RequestParam("number") Integer number) {
        cartService.changeNumberProduct(request.getSession(), id, number);
    }

    /**
     * Удаление продукта из корзины
     *
     * @param id
     */
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@RequestParam Long id) {
        cartService.deleteFromCart(request.getSession(), id);
    }

    /**
     * Страница с заказом
     * цена на доставку захардкожена
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void buyProductsPage(Model model) {
        User user = userService.getAutUser();
        if (addressService.getAddressByUserId(user.getId()) != null) {
            Address address = addressService.getAddressByUserId(user.getId());
            Date d = new Date(System.currentTimeMillis());
            BigDecimal tp = new BigDecimal(0);
            for (Cart c : user.getCart()) {
                tp = tp.add(c.getGoodId().getPrice().multiply(new BigDecimal(c.getNumber())));
            }
            String addr = address.getCity() + " " + address.getStreet() + " " + address.getHouse() + " " + address.getFlat() + " " + address.getIndex();
            Order order = new Order(user, addr, d, tp.add(DELIVERY_CHARGES), "open", null);
            orderService.add(order);
            cartService.addInOrder(order);

        }
    }
}

