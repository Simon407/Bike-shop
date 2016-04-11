package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Информация о категории
 */
@Entity
@Table(name = "h_categories")
public class Category{

    /**
     * id раздела
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentId;

    /**
     * id категории
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /**
     * Название категории
     */
    private String name;


    /**
     * Список дочерних категорий
     */
    @OneToMany(mappedBy = "parentId")
    private List<Category> children;

    /**
     * Ссылка на соответствующий раздел
     */
    private String link;

    /**
     * Ссылка на картинку категории
     */
    private String picLink;

    /**
     * Описание категории
     */
    private String description;

    public Category() {
    }

    public Category(Category parentId, String name, String link) {
        this.parentId = parentId;
        this.name = name;
        this.link = link;
    }

    public Category(Category parentId, String name, String link, String picLink, String description) {
        this.parentId = parentId;
        this.name = name;
        this.link = link;
        this.picLink = picLink;
        this.description = description;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public Category getParentId() {
        return parentId;
    }

    public void setParentId(Category parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Category(Category parentId, String name, List<Category> children, String link, String picLink, String description) {
        this.parentId = parentId;
        this.name = name;
        this.children = children;
        this.link = link;
        this.picLink = picLink;
        this.description = description;
    }
}
