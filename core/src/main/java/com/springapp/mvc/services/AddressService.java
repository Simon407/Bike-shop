package com.springapp.mvc.services;

import com.springapp.mvc.entity.Address;
import com.springapp.mvc.repositories.hibernate.AddressRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressService {

    @Autowired
    private AddressRepositoryHibernate addressRepositoryHibernate;

    @Transactional
    public void add(Address address) {
        addressRepositoryHibernate.add(address);
    }

    @Transactional
    public void delete(Address address) {
        addressRepositoryHibernate.delete(address);
    }

    @Transactional
    public Address getAddressById(Long id) {
        return addressRepositoryHibernate.getAddressById(id);
    }

    @Transactional
    public void update(Address address) {
        addressRepositoryHibernate.update(address);
    }

    @Transactional
    private List<Address> getAllAddress() {
        return addressRepositoryHibernate.getAllAddress();
    }

    public Address getAddressByUserId(Long userId) {
        List<Address> carts = new ArrayList<Address>();
        for (Address c : getAllAddress()) {
            if (c.getUserId().getId().equals(userId)) {
                carts.add(c);
            }
        }
        if(carts.size() != 0){
            return carts.get(0);
        }else return null;
    }

    public List<Address> getListAddressByUserId(Long userId) {
        List<Address> carts = new ArrayList<Address>();
        for (Address c : getAllAddress()) {
            if (c.getUserId().getId().equals(userId)) {
                carts.add(c);
            }
        }
        return carts;
    }
}
