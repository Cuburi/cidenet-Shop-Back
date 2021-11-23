package com.CidenetShop.CidenetShopBackend.security.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String typeId;
    @NonNull
    private String document;
    @NonNull
    private String address;
    @NonNull
    private String phone;
    @NonNull
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(@NonNull String name, @NonNull String email, @NonNull String password, @NonNull String typeId, @NonNull String document, @NonNull String address, @NonNull String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.typeId = typeId;
        this.document = document;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(@NonNull String typeId) {
        this.typeId = typeId;
    }

    @NonNull
    public String getDocument() {
        return document;
    }

    public void setDocument(@NonNull String document) {
        this.document = document;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    @NonNull
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(@NonNull Set<Role> roles) {
        this.roles = roles;
    }
}
