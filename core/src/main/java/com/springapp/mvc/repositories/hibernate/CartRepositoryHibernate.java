package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Cart;
import com.springapp.mvc.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepositoryHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Cart cart) {
        curSession().saveOrUpdate(cart);
        curSession().flush();
    }

    public void delete(Cart cart) {
        curSession().delete(cart);
        curSession().flush();
    }

    public int deleteCartByGoodsId(Long goodId) {
        Query query =  curSession().createQuery("delete from Cart where goodId = :param");
        query.setLong("param", goodId);
        return query.executeUpdate();
    }

    public Cart getCartById(Long id) {
        return (Cart) curSession().get(Cart.class, id);
    }

    public List<Cart> getCartsByUserId(Long userId) {
        List<Cart> carts = new ArrayList<Cart>();
        try {
            carts = (List<Cart>) curSession().createQuery("select new list(c.id, c.goodId, c.userId, c.number) from Cart c " +
                    "where c.userId = :userId")
                    .setLong("userId", userId)
                    .list();
        } catch (Exception e) {
            System.err.println("Error in getAllGoods(): " + e.getMessage());
        }
        return carts;
    }

    public List<Cart> getAllCarts() {
        return curSession().createCriteria(Cart.class).list();
    }
}
