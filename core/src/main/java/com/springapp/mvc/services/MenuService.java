package com.springapp.mvc.services;

import com.springapp.mvc.entity.Category;
import com.springapp.mvc.repositories.hibernate.CategoryRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * Сервис для работы с навигацией
 */
@Service
public class MenuService {

    @Autowired
    private CategoryRepositoryHibernate categoryRepository;

    @Transactional
    public void addGood(Category goodsInfo) {
        categoryRepository.addCategory(goodsInfo);
    }

    @Transactional
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    /**
     * Получаем основное меню сайта
     */
    public List<Category> getMainMenu() {
        List<Category> listMenu = new ArrayList<Category>();
        for (Category c : getAllCategory()) {
            if (!c.getChildren().isEmpty()){
                listMenu.add(c);
            }
        }
        return listMenu;
    }
}
