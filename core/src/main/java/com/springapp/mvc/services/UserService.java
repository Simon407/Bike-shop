package com.springapp.mvc.services;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.repositories.hibernate.UserRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepositoryHibernate userRepository;

    @Transactional
    public void add(User user) {
        userRepository.add(user);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
