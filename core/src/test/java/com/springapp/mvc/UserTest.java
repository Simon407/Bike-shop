package com.springapp.mvc;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    @Autowired
    private UserService service;

    @Before
    public void setUp(){
        User user = new User(true,"sasa@bk.ru","15de21c670ae7c3f6f3f1f37029303c9","SAD","ROLE_USER","89534353453");
        service = mock(UserService.class);
        when(service.getUserByLogin("sasa@bk.ru")).thenReturn(user);
    }

    @Test
    public void usernameTest(){
        User user = service.getUserByLogin("sasa@bk.ru");
        Assert.assertEquals("sasa@bk.ru",user.getLogin());
    }

    @Test
    public void emailTest(){
        User user = service.getUserByLogin("sasa@bk.ru");
        Assert.assertEquals("sasa@bk.ru",user.getLogin());
    }

    @Test
    public void nameTest(){
        User user = service.getUserByLogin("sasa@bk.ru");
        Assert.assertEquals("SAD",user.getFio());
    }

    @Test
    public void roleTest(){
        User user = service.getUserByLogin("sasa@bk.ru");
        Assert.assertEquals("ROLE_USER",user.getRole());
    }

}
