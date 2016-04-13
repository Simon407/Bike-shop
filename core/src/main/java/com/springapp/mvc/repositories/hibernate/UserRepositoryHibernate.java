package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryHibernate{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(User user) {
        curSession().saveOrUpdate(user);
    }

    public User getUserByLogin(String login) {
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

    public User getUserById(Long goodId) {
        return (User) curSession().get(User.class, goodId);
    }
}
