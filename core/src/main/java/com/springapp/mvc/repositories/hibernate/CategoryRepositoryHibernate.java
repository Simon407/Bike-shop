package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity2.Category;
import com.springapp.mvc.repositories.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Gataullin Kamil
 * 16.03.2016 22:21
 */
@Repository
public class CategoryRepositoryHibernate implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCategory(Category categoryInfo) {
        curSession().save(categoryInfo);
    }
}
