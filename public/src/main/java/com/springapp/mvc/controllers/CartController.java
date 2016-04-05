package com.springapp.mvc.controllers;

import com.springapp.mvc.info.MenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springapp.mvc.services.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Ann on 28.03.2016.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(method = {RequestMethod.GET})
    public String mainCatalog(HttpServletRequest request) {
        List<MenuInfo> listMenu = menuService.getCategoryForMenu();
        request.setAttribute("listMenu", listMenu);
        return "cart";
    }
}
