package com.springapp.mvc.services;

import org.springframework.stereotype.Service;

/**
 * Created by Ann on 24.02.2016.
 */
@Service
public class CartService {

    public static final String CART = "sessionCart";
//
//    public List<GoodsInfo> addInCart(GoodsInfo goodInfo, HttpServletRequest request) {
//        List<GoodsInfo> cart = (List<GoodsInfo>) request.getSession().getAttribute(CART);
//        if (cart == null) {
//            cart = new ArrayList<GoodsInfo>();
//        }
//        cart.add(goodInfo);
//        request.getSession().setAttribute(CART, cart);
//        return cart;
//    }
}
