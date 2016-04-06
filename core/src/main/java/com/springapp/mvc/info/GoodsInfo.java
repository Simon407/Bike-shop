package com.springapp.mvc.info;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Основная информация о товаре
 */
@Entity
@Table(name = "h_goods")
public class GoodsInfo {

    /**
     * Ссылка на картинку товара
     */
    private String picLink;

    /**
     * Название товара
     */
    private String name;

    /**
     * Номер модели
     */
    private String modelNo;

    /**
     * id товара
     */
    private Long id;

    /**
     * Цена
     */
    private BigDecimal price;

    /**
     * id главной категории товара
     */
    private Long mainId;

    /**
     * id категории товара
     */
    private Long typeId;

    /**
     * id бренда товара
     */
    private Long brandId;

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GoodsInfo() {
    }

    public GoodsInfo(Long id) {
        this.id = id;
    }

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
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

    public GoodsInfo(String picLink, String name, String modelNo, Long id, BigDecimal price, Long mainId, Long typeId, Long brandId, String description) {
        this.picLink = picLink;
        this.name = name;
        this.modelNo = modelNo;
        this.id = id;
        this.price = price;
        this.mainId = mainId;
        this.typeId = typeId;
        this.brandId = brandId;
        this.description = description;
    }
}
