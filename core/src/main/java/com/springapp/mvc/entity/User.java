package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "h_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private boolean enable;
    private String login;
    private String hashPass;
    private String fio;
    private String role;
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Cart> cart;

    public User() {
    }

    public User(boolean enable, String login, String hashPass, String fio, String role, String phone) {
        this.enable = enable;
        this.login = login;
        this.hashPass = hashPass;
        this.fio = fio;
        this.role = role;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
