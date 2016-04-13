package com.springapp.mvc.services;

import com.springapp.mvc.entity.Order;
import com.springapp.mvc.repositories.hibernate.OrderRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepositoryHibernate repositoryHibernate;

    @Transactional
    public void add(Order order) {
        repositoryHibernate.add(order);
    }

    @Transactional
    private void delete(Order order) {
        repositoryHibernate.delete(order);
    }

    @Transactional
    public Order getOrderById(Long id) {
       return repositoryHibernate.getOrderById(id);
    }

//    @Transactional
//    public Order getOrderByUserId(Long userId) {
//        return repositoryHibernate.getOrderByUserId(userId);
//    }

    @Transactional
    private List<Order> getAllOrders() {
        return repositoryHibernate.getAllOrders();
    }


    public List<Order> getOrdersByUserId(Long userId) {
        List<Order> carts = new ArrayList<Order>();
        for (Order c :getAllOrders()) {
            if (c.getUserId().getId().equals(userId)) {
                carts.add(c);
            }
        }
        return carts;
    }
}
