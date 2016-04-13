package com.springapp.mvc.services;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.repositories.hibernate.UserRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Transactional
    public void update(User user) {
        userRepository.update(user);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    private String getAut() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    public User getAutUser() {
        String username = getAut();
        if (!username.equals("anonymousUser")) {
            return getUserByLogin(username);
        }else return null;
    }
}
