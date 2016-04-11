package com.springapp.mvc.info;

import com.springapp.mvc.entity2.User;

import java.util.Map;

/**
 * Содержимое корзины
 */

public class CartInfo {

    /**
     * key - id товара, value - кол-во товара
     */
    private Map<Long, Integer> goods;

    /**
     * айди клиента
     */
    private User userId;

    public CartInfo(Map<Long, Integer> goods, User userId) {
        this.goods = goods;
        this.userId = userId;
    }

    public User getUserId() {
        return userId;
    }

    public CartInfo() {
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Long, Integer> goods) {
        this.goods = goods;
    }

    /**
     * Получаем кол-во товара в корзине
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     * @return кол-во товара в корзине
     */
    public Integer getCount(Long goodId) {
        if (goods == null || goodId == null)
            return null;
        return goods.get(goodId);
    }

    /**
     * Получаем кол-во товара в корзине
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @return кол-во товара в корзине
     */
    public Integer getAllCount() {
        return goods.size();
    }

    /**
     * Есть ли в корзине товар с этим id
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     */
    public boolean containsGoodId(Long goodId) {
        if (goods == null || goodId == null)
            return false;
        return goods.containsKey(goodId);
    }
}
