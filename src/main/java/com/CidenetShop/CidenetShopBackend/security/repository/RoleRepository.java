package com.CidenetShop.CidenetShopBackend.security.repository;

import com.CidenetShop.CidenetShopBackend.security.enums.RoleName;
import com.CidenetShop.CidenetShopBackend.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
