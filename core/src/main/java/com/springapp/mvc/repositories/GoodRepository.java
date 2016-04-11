package com.springapp.mvc.repositories;

import com.springapp.mvc.entity.Goods;

import java.util.List;


public interface GoodRepository {

    void addGood(Goods goodInfo);

    void updateGood(Goods goodInfo);

    void deleteGood(Long goodId);

    Goods getGoodById(Long goodId);

    public List<Goods> getAllGoods();
}
