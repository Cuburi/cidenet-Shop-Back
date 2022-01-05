package com.CidenetShop.CidenetShopBackend.repository;

import com.CidenetShop.CidenetShopBackend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
}
