package com.springapp.mvc.info;

/**
 * Информация о категории
 */
public class CategoryInfo {

    /**
     * id раздела
     */
    private Long mainId;

    /**
     * id категории
     */
    private Long id;

    /**
     * Название категории
     */
    private String name;

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

    public CategoryInfo() {
    }

    public CategoryInfo(Long mainId, Long id, String name, String link) {
        this.mainId = mainId;
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public CategoryInfo(Long mainId, Long id, String name, String link, String picLink, String description) {
        this.mainId = mainId;
        this.id = id;
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

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
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
}
