package com.CidenetShop.CidenetShopBackend.security.repository;

import com.CidenetShop.CidenetShopBackend.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long> {
    Optional<User> findAllByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    boolean existsById(Long id);
    Optional<User> findAllById(Long id);

}
