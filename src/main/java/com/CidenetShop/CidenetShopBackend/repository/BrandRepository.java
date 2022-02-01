package com.CidenetShop.CidenetShopBackend.repository;

import com.CidenetShop.CidenetShopBackend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository <Brand, Long> {

    boolean existsByName(String name);
}
