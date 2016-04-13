package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Order order) {
        curSession().saveOrUpdate(order);
        curSession().flush();
    }

    public Order getOrderByUserId(Long id) {
        return (Order) curSession().createCriteria(Order.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    public Order getOrderById(Long id) {
        return (Order) curSession().get(Order.class, id);
    }

    public void delete(Order order) {
        curSession().delete(order);
        curSession().flush();
    }

    public List<Order> getAllOrders() {
        return curSession().createCriteria(Order.class).list();
    }
}
