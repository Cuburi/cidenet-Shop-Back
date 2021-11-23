package com.CidenetShop.CidenetShopBackend.security.model;

import com.CidenetShop.CidenetShopBackend.security.enums.RoleName;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private RoleName rolName;

    public Role() {
    }

    public Role(Long id, @NonNull RoleName rolName) {
        this.id = id;
        this.rolName = rolName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public RoleName getRolName() {
        return rolName;
    }

    public void setRolName(@NonNull RoleName rolName) {
        this.rolName = rolName;
    }
}
