package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Address address) {
        curSession().saveOrUpdate(address);
        curSession().flush();
    }

    public Address getAddressByUserId(Long id) {
        return (Address) curSession().createCriteria(Address.class)
                .add(Restrictions.eq("user_id", id)).uniqueResult();
    }

    public Address getAddressById(Long id) {
        return (Address) curSession().get(Address.class, id);
    }

    public void delete(Address address) {
        curSession().delete(address);
        curSession().flush();
    }

    public void update(Address address) {
        curSession().update(address);
        curSession().flush();
    }

    public List<Address> getAllAddress() {
        return curSession().createCriteria(Address.class).list();
    }
}
