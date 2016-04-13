package com.springapp.mvc;

import com.springapp.mvc.entity.Address;
import com.springapp.mvc.services.AddressService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressTest {

    @Autowired
    private AddressService service;

    @Before
    public void setUp(){
        Address address = new Address(1L,"Kazan", "Main", "102", "144", "420059");
        service = mock(AddressService.class);
        when(service.getAddressById(1L)).thenReturn(address);
    }

    @Test
    public void cityTest(){
        Address address = service.getAddressById(1L);
        Assert.assertEquals("Kazan",address.getCity());
    }

    @Test
    public void streetTest(){
        Address address = service.getAddressById(1L);
        Assert.assertEquals("Main",address.getStreet());
    }

    @Test
    public void houseTest(){
        Address address = service.getAddressById(1L);
        Assert.assertEquals("102",address.getHouse());
    }

    @Test
    public void flatTest(){
        Address address = service.getAddressById(1L);
        Assert.assertEquals("144",address.getFlat());
    }

    @Test
    public void indexTest(){
        Address address = service.getAddressById(1L);
        Assert.assertEquals("420059",address.getIndex());
    }
}
