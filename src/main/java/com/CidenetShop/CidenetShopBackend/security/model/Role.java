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
    private RoleName roleName;

    public Role() {
    }

    public Role(@NonNull RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(@NonNull RoleName roleName) {
        this.roleName = roleName;
    }
}
