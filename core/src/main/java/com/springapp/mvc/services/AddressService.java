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
    private void delete(Address address) {
        addressRepositoryHibernate.delete(address);
    }

    @Transactional
    private List<Address> getAllAddress() {
        return addressRepositoryHibernate.getAllAddress();
    }

//    @Transactional
//    public Address getAddressByUserId(Long userId) {
//        return addressRepositoryHibernate.getAddressByUserId(userId);
//    }

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
}
