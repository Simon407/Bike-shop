package com.springapp.mvc.repositories;

import com.springapp.mvc.info.GoodsInfo;


public interface GoodRepository {

    void addGood(GoodsInfo goodInfo);

    void updateGood(GoodsInfo goodInfo);

    void deleteGood(Long goodId);

    GoodsInfo getGoodById(Long goodId);
}
