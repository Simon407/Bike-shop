package com.springapp.mvc.services;

import com.springapp.mvc.entity.Goods;
import com.springapp.mvc.repositories.hibernate.GoodRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodRepositoryHibernate goodRepository;

    @Transactional
    public void addGood(Goods goodsInfo) {
        goodRepository.addGood(goodsInfo);
    }

    @Transactional
    public List<Goods> getAllGoods() {
        return goodRepository.getAllGoods();
    }

    @Transactional
    public Goods getGoodsById(Long id) {
        return goodRepository.getGoodById(id);
    }

//    // FIXME: не интегрируется с шаблоном ftl
//    @Transactional
//    public List<Goods> getGoodsByTypeId(Long typeId) {
//        return goodRepository.getGoodsByTypeId(typeId);
//    }
//
//    // FIXME: не интегрируется с шаблоном ftl
//    @Transactional
//    public List<Goods> getGoodsByMainId(Long mainId) {
//        return goodRepository.getGoodsByMainId(mainId);
//    }

    /**
     * Получение товаров по айди категории
     *
     * @return лист товаров
     */
    public List<Goods> getGoodsByTypeId(Long typeid) {
        List<Goods> goodsInfoList = new ArrayList<Goods>();
        for (Goods g : getAllGoods()) {
            if (g.getTypeId().getId().equals(typeid)) {
                goodsInfoList.add(g);
            }
        }
        return goodsInfoList;
    }


    /**
     * Получение товаров по айди основной категории т.е. "Веловипеды", "Запчасти"
     *
     * @return лист товаров
     */
    public List<Goods> getGoodsByMainId(Long id) {
        List<Goods> goodsInfoList = new ArrayList<Goods>();
        for (Goods g : getAllGoods()) {
            if (g.getTypeId().getParentId().getId().equals(id)) {
                goodsInfoList.add(g);
            }
        }
        return goodsInfoList;
    }
}
