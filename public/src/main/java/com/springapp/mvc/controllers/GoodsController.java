package com.springapp.mvc.controllers;

import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private GoodsService goodsService;

    /**
     * Отображение карточки товара
     *
     * @param goodId id товара
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderGoodPage(@PathVariable("id") Long goodId, ModelMap model) {
        //TODO details-product-slider- откуда картинки доставать и ссылки? freemarker только листы поддерживает?
        //TODO дописать проверку на размер goods
        //TODO названия брендов и категорий а не айди
        model.addAttribute("listMenu", menuService.getCategoryForMenu());
        model.addAttribute("goods", goodsService.getGoodsById(goodId));
        return "goods";
    }
}
