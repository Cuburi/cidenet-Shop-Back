package com.CidenetShop.CidenetShopBackend.security.model;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMain implements UserDetails {
    private String name;
    private String email;
    private String password;
    private String typeId;
    private String document;
    private String address;
    private String phone;
    private Collection<? extends GrantedAuthority> authorities;

    public UserMain(String name, String email, String password, String typeId, String document, String address, String phone, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.typeId = typeId;
        this.document = document;
        this.address = address;
        this.phone = phone;
        this.authorities = authorities;
    }

    public static UserMain build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRolName().name())).collect(Collectors.toList());
        return new UserMain(user.getName(), user.getEmail(), user.getPassword(), user.getTypeId(), user.getDocument(), user.getAddress(), user.getPhone(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
