package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.GoodsService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Контроллер для работы с корзиной
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CartService cartService;

    @Autowired
    private GoodsService goodsService;


    /**
     * Отображение содержимого корзины
     * При авторизации переносится вся корзина из сесии в бд
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        cartService.transfer(request.getSession());
        request.setAttribute("goods", goodsService.getAllGoods());
        List<Cart> list = cartService.getCartsByUsername();
        request.setAttribute("carts", list);
        if(list != null){
            request.setAttribute("cartsSize", new Integer(list.size()));
        }
        return "cart";
    }

    /**
     * Добавление товара в корзину
     * goodId - id товара
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String addOrDeleteCart(ModelMap model) {
//        String move = request.getParameter("move");
//        String id = request.getParameter("id");
//        if (id != null) {
//            Long goodId = Long.valueOf(id);
//            if (move.equals("add")) {
//                cartService.addInCart(request.getSession(), goodId, 1);
//            } else cartService.deleteFromCart(request.getSession(), goodId);
//        }
//        cartService.transfer(request.getSession());
//        model.addAttribute("goods", goodsService.getAllGoods());
//        List<Cart> list = cartService.getCartsByUsername();
//        request.setAttribute("carts", list);
//        if(list != null){
//            request.setAttribute("cartsSize", new Integer(list.size()));
//        }
        return "cart";
    }

    /**
     * Добавление продукта в корзину
     * @param id
     */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestParam Long id) {
        cartService.addInCart(request.getSession(), id, 1);
    }

    /**
     * Изменение количества товаров в корзине
     * @param id
     * @param number
     */
    @RequestMapping(value = "/changeNumberProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeNumberProduct(@RequestParam("id") Long id, @RequestParam("number") Integer number) {
        cartService.changeNumberProduct(request.getSession(),id, number);
    }

    /**
     * Удаление продукта из корзины
     * @param id
     */
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@RequestParam Long id) {
        cartService.deleteFromCart(request.getSession(), id);
    }
}

