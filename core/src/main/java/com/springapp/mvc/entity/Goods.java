package com.springapp.mvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Основная информация о товаре
 */
@Entity
@Table(name = "h_goods")
public class Goods {

    /**
     * id товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    /**
     * Название товара
     */
    private String name;

    /**
     * Номер модели
     */
    private String modelNo;

    /**
     * Цена
     */
    private BigDecimal price;

    /**
     * Ссылка на картинку товара
     */
    private String picLink;
    /**
     * id категории товара
     */
    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Category typeId;

    /**
     * id бренда товара
     */
    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brandId;

    /**
     * описание товара
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Goods() {
    }

    public Goods(Long id) {
        this.id = id;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public Category getTypeId() {
        return typeId;
    }

    public void setTypeId(Category typeId) {
        this.typeId = typeId;
    }

    public Goods(String name, String modelNo, BigDecimal price, String picLink, Category typeId, Brand brandId, String description) {
        this.name = name;
        this.modelNo = modelNo;
        this.price = price;
        this.picLink = picLink;
        this.typeId = typeId;
        this.brandId = brandId;
        this.description = description;
    }
}
