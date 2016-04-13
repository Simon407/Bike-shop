package com.springapp.mvc;

import com.springapp.mvc.entity.Goods;
import com.springapp.mvc.services.GoodsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GoodsTest {

    @Autowired
    private GoodsService service;

    @Before
    public void setUp(){
        Goods goods = new Goods(1L,"BIG BOY","6789",new BigDecimal(500),"description");
        service = mock(GoodsService.class);
        when(service.getGoodsById(1L)).thenReturn(goods);
    }

    @Test
    public void nameTest(){
        Goods goods = service.getGoodsById(1L);
        Assert.assertEquals("BIG BOY",goods.getName());
    }

    @Test
    public void modelTest(){
        Goods goods = service.getGoodsById(1L);
        Assert.assertEquals("6789",goods.getModelNo());
    }

    @Test
    public void priceTest(){
        Goods goods = service.getGoodsById(1L);
        Assert.assertEquals(new BigDecimal(500),goods.getPrice());
    }

    @Test
    public void descriptionTest(){
        Goods goods = service.getGoodsById(1L);
        Assert.assertEquals("description",goods.getDescription());
    }

}
