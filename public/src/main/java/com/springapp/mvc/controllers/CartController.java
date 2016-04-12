package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeMenuInfo;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.MenuService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        request.setAttribute("goods", goodsService.getAllGoods());
        return "cart";
    }

    /**
     * Добавление товара в корзину
     * <p>
     * goodId - id товара
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String addOrDeleteCart(ModelMap model) {
        String move = request.getParameter("move");
        String id = request.getParameter("id");
        if (id != null) {
            Long goodId = Long.valueOf(id);
            model.addAttribute("goods", goodsService.getAllGoods());
            if (move.equals("add")) {
                cartService.addInCart(request.getSession(), goodId, 1);
            } else {
                cartService.deleteFromCart(request.getSession(), goodId);
            }
        }
        return "cart";
    }
}

