package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Cart cart) {
        curSession().save(cart);
    }

    public void delete(Cart cart) {
        curSession().delete(cart);
    }

    public Cart getCartsByUserId(String userId) {
        return (Cart) curSession().createCriteria(User.class)
                .add(Restrictions.eq("user_id", userId)).uniqueResult();
    }
}
