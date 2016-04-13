package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryMenu;
import com.springapp.mvc.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * Отображение карточки товара
     *
     * @param goodId id товара
     */
    @IncludeCategoryMenu
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderGoodPage(@PathVariable("id") Long goodId, ModelMap model) {
        if (goodsService.getGoodsById(goodId) != null) {
            model.addAttribute("good", goodsService.getGoodsById(goodId));
            return "goods";
        } else return "404";
    }
}
