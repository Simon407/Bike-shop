package com.springapp.mvc.services;

import com.springapp.mvc.info.GoodsInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ann on 24.02.2016.
 */
@Service
public class GoodsService {
    /**
     * Получаем описание товаров
     */
    public List<GoodsInfo> getGoodsDescription() {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        goodsInfoList.add(new GoodsInfo("/resources/images/bik1.jpg", "BIG BOY", "3498", 1L, new BigDecimal(300), 1L, 1L, 1L, "The first mechanically-propelled, " +
                "two-wheeled vehicle may have been built by Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, " +
                "although the claim is often disputed. He is also associated with the first recorded instance of a " +
                "cycling traffic offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous" +
                " \"gentleman from Dumfries-shire... bestride a velocipede... of ingenious design\" knocked " +
                "over a little girl in Glasgow and was fined five The word bicycle first appeared in English " +
                "print in The Daily News in 1868, to describe \"Bysicles and trysicles\" on the " +
                "\"Champs Elysées and Bois de Boulogne."));

        goodsInfoList.add(new GoodsInfo("/resources/images/bik2.jpg", "SCOTT SPARK", "3498", 2L, new BigDecimal(400), 1L, 1L, 2L, "The first mechanically-propelled, " +
                "two-wheeled vehicle may have been built by Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, " +
                "although the claim is often disputed. He is also associated with the first recorded instance of a " +
                "cycling traffic offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous" +
                " \"gentleman from Dumfries-shire... bestride a velocipede... of ingenious design\" knocked " +
                "over a little girl in Glasgow and was fined five The word bicycle first appeared in English " +
                "print in The Daily News in 1868, to describe \"Bysicles and trysicles\" on the " +
                "\"Champs Elysées and Bois de Boulogne."));

        goodsInfoList.add(new GoodsInfo("/resources/images/bik3.jpg", "ROCK HOVER", "3498", 3L, new BigDecimal(500), 1L, 1L, 3L, "The first mechanically-propelled, " +
                "two-wheeled vehicle may have been built by Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, " +
                "although the claim is often disputed. He is also associated with the first recorded instance of a " +
                "cycling traffic offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous" +
                " \"gentleman from Dumfries-shire... bestride a velocipede... of ingenious design\" knocked " +
                "over a little girl in Glasgow and was fined five The word bicycle first appeared in English " +
                "print in The Daily News in 1868, to describe \"Bysicles and trysicles\" on the " +
                "\"Champs Elysées and Bois de Boulogne."));

        goodsInfoList.add(new GoodsInfo("/resources/images/bik4.jpg", "SANSACHG", "3498", 4L, new BigDecimal(600), 1L, 1L, 4L, "The first mechanically-propelled, " +
                "two-wheeled vehicle may have been built by Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, " +
                "although the claim is often disputed. He is also associated with the first recorded instance of a " +
                "cycling traffic offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous" +
                " \"gentleman from Dumfries-shire... bestride a velocipede... of ingenious design\" knocked " +
                "over a little girl in Glasgow and was fined five The word bicycle first appeared in English " +
                "print in The Daily News in 1868, to describe \"Bysicles and trysicles\" on the " +
                "\"Champs Elysées and Bois de Boulogne."));

        goodsInfoList.add(new GoodsInfo("/resources/images/bik5.jpg", "JETT MAC", "3499", 5L, new BigDecimal(300), 1L, 1L, 5L, "The first mechanically-propelled, " +
                "two-wheeled vehicle may have been built by Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, " +
                "although the claim is often disputed. He is also associated with the first recorded instance of a " +
                "cycling traffic offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous" +
                " \"gentleman from Dumfries-shire... bestride a velocipede... of ingenious design\" knocked " +
                "over a little girl in Glasgow and was fined five The word bicycle first appeared in English " +
                "print in The Daily News in 1868, to describe \"Bysicles and trysicles\" on the " +
                "\"Champs Elysées and Bois de Boulogne."));

        goodsInfoList.add(new GoodsInfo("/resources/images/bik6.jpg", "SANSACHG", "3500", 6L, new BigDecimal(400), 1L, 3L, 6L, "The first mechanically-propelled, " +
                "two-wheeled vehicle may have been built by Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, " +
                "although the claim is often disputed. He is also associated with the first recorded instance of a " +
                "cycling traffic offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous" +
                " \"gentleman from Dumfries-shire... bestride a velocipede... of ingenious design\" knocked " +
                "over a little girl in Glasgow and was fined five The word bicycle first appeared in English " +
                "print in The Daily News in 1868, to describe \"Bysicles and trysicles\" on the " +
                "\"Champs Elysées and Bois de Boulogne."));

        return goodsInfoList;
    }

    /**
     * Получение товаров по айди категории
     *
     * @return лист товаров
     *
     */
    public List<GoodsInfo> getGoodsByTypeId(Long mainid, Long typeid) {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        for (GoodsInfo g : getGoodsDescription()) {
            if (g.getTypeId().equals(typeid) && g.getMainId().equals(mainid)) {
                goodsInfoList.add(g);
            }
        }
        return goodsInfoList;
    }

    /**
     * Получение 4х товаров по айди основной категории
     *
     * @return лист товаров
     *
     */
    public List<GoodsInfo> getGoodsForMainCategoryPage(Long mainid) {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        for (Long i = 1L; i <= 4L; i++) {
            goodsInfoList.addAll(getFourGoodsByTypeId(mainid, i));
        }
        return goodsInfoList;
    }

    private List<GoodsInfo> getFourGoodsByTypeId(Long mainid, Long id) {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        int index = 0;
        for (GoodsInfo g : getGoodsDescription()) {
            if (g.getTypeId().equals(id) && g.getMainId().equals(mainid) && index < 4) {
                goodsInfoList.add(g);
                index++;
            }
        }
        return goodsInfoList;
    }

    /**
     * Получение товаров по айди основной категории т.е. "Веловипеды", "Запчасти"
     *
     * @return лист товаров
     *
     */
    public List<GoodsInfo> getGoodsByMainId(Long id) {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        for (GoodsInfo g : getGoodsDescription()) {
            if (g.getMainId().equals(id)) {
                goodsInfoList.add(g);
            }
        }
        return goodsInfoList;
    }

    /**
     * Получение товаров по их айди
     *
     * @return лист товаров
     *
     */
    public List<GoodsInfo> getGoodsById(Long id) {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        for (GoodsInfo g : getGoodsDescription()) {
            if (g.getId().equals(id)) {
                goodsInfoList.add(g);
            }
        }
        return goodsInfoList;
    }
}
