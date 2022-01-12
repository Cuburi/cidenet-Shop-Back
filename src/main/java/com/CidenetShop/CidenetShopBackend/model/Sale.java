package com.CidenetShop.CidenetShopBackend.model;

import com.CidenetShop.CidenetShopBackend.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private float totalPrice;

    @NonNull
    private Date date;

    @NonNull
    private String address;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("sale")
    private User user;

    public Sale(long id, float totalPrice, @NonNull Date date, @NonNull String address, User user) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.date = date;
        this.address = address;
        this.user = user;
    }

    public Sale() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }
}
