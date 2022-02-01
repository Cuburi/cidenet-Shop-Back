package com.CidenetShop.CidenetShopBackend.repository;



import com.CidenetShop.CidenetShopBackend.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ColorRepository extends JpaRepository <Color,Long> {
    boolean existsByName(String name);
}
