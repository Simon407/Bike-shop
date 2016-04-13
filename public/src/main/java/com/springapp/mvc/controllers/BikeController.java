package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryMenu;
import com.springapp.mvc.entity.Goods;
import com.springapp.mvc.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/bicycles")
public class BikeController {

    private static final Integer GOODS_COUNT = 9;
    private static final Integer LIMIT = 4;

    /**
     * id главной категории товара т.е. "велосипеды"
     */
    private static final Long MAIN_ID = 1L;

    @Autowired
    private GoodsService goodsService;

    /**
     * Отображение каталога велосипедов по категориям
     *
     * @param id    id категории
     * @param page  номер страницы
     * @param limit кол-во товаров отображаемых на странице
     * @return отображение каталога
     * <p>
     * число категорий - 3, если ввести другое значение id то будт 404 страница
     */
    @IncludeCategoryMenu
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalogById(@PathVariable("id") Long id, @RequestParam(value = "page", required = false, defaultValue = "1")
            Integer page, Long limit, ModelMap model) {
        List<Goods> list = goodsService.getGoodsByTypeId(id);
        if (id >= 5 && id <= 7 && (!list.isEmpty())) {
            model.addAttribute("mainId", MAIN_ID);
            model.addAttribute("goods", list);
            model.addAttribute("id", id);
            model.addAttribute("page", page);
            model.addAttribute("limit", limit == null ? LIMIT : limit);
            model.addAttribute("goodsCount", GOODS_COUNT);
            return "bicycles";
        } else return "404";
    }


    /**
     * Отображение главной страницы каталога велосипедов
     *
     * @return отображение каталога
     *
     * На главной странице каталога отображаются все категории
     * По 4 товара на каждую категорию
     * MainId - id главной категории товара т.е. "велосипеды"
     */
    @IncludeCategoryMenu
    @RequestMapping(method = RequestMethod.GET)
    public String renderCatalog(ModelMap model) {
        model.addAttribute("mainId", MAIN_ID);
        model.addAttribute("goods", goodsService.getGoodsByMainId(MAIN_ID));
        return "bicycles";
    }
}
