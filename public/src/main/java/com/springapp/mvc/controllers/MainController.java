package com.springapp.mvc.controllers;

import com.springapp.mvc.info.CategoryInfo;
import com.springapp.mvc.info.MenuInfo;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Контроллер главной страницы
 */
@Controller
public class MainController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private GoodsService goodsService;

    //TODO слайдер с байками, откуда картинки брать?
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("bikes",goodsService.getGoodsByMainId(1L));
        model.addAttribute("listMenu",menuService.getCategoryForMenu());
        return "main";
    }

}