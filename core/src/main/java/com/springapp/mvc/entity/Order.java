package com.springapp.mvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "h_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address addressId;

    private Date creationTime;
    private BigDecimal totalSum;
    private String status;
    private Date payTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Cart> cart;

    public Order() {
    }

    public Order(User userId, Address addressId, Date creationTime, BigDecimal totalSum, String status, Date payTime) {
        this.userId = userId;
        this.addressId = addressId;
        this.creationTime = creationTime;
        this.totalSum = totalSum;
        this.status = status;
        this.payTime = payTime;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date createTime) {
        this.creationTime = createTime;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
