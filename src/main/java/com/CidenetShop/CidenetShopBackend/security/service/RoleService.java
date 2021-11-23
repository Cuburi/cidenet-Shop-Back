package com.CidenetShop.CidenetShopBackend.security.service;

import com.CidenetShop.CidenetShopBackend.security.enums.RoleName;
import com.CidenetShop.CidenetShopBackend.security.model.Role;
import com.CidenetShop.CidenetShopBackend.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }
}
