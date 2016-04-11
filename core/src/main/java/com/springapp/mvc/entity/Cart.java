package com.springapp.mvc.entity;

import javax.persistence.*;

/**
 * Содержимое корзины
 */


@Entity
@Table(name = "h_carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "good_id")
    private Goods goodId;

    private Integer number;
    /**
     * айди клиента
     */
    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;


    public User getUserId() {
        return userId;
    }

    public Cart() {
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Cart(Goods goodId, Integer number, User userId) {
        this.goodId = goodId;
        this.number = number;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoodId() {
        return goodId;
    }

    public void setGoodId(Goods goodId) {
        this.goodId = goodId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    //    /**
//     * Получаем кол-во товара в корзине
//     * Для FreeMarker, так как он не умеет работать с числовыми ключами
//     *
//     * @param goodId id товара
//     * @return кол-во товара в корзине
//     */
//    public Integer getCount(Long goodId) {
//        if (goods == null || goodId == null)
//            return null;
//        return goods.get(goodId);
//    }
//
//    /**
//     * Получаем кол-во товара в корзине
//     * Для FreeMarker, так как он не умеет работать с числовыми ключами
//     *
//     * @return кол-во товара в корзине
//     */
//    public Integer getAllCount() {
//        return goods.size();
//    }
//
//    /**
//     * Есть ли в корзине товар с этим id
//     * Для FreeMarker, так как он не умеет работать с числовыми ключами
//     *
//     * @param goodId id товара
//     */
//    public boolean containsGoodId(Long goodId) {
//        if (goods == null || goodId == null)
//            return false;
//        return goods.containsKey(goodId);
//    }
}
