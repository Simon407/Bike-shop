package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Category;
import com.springapp.mvc.repositories.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryHibernate{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCategory(Category categoryInfo) {
        curSession().save(categoryInfo);
    }

    public void updateCategory(Category category) {
        curSession().saveOrUpdate(category);
    }

    public void deleteCategory(Long goodId) {
        curSession().delete(new Category(goodId));
    }

    public Category getCategoryById(Long categoryId) {
        return (Category) curSession().get(Category.class, categoryId);
    }

    public List<Category> getAllCategory() {
        return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
    }
}
