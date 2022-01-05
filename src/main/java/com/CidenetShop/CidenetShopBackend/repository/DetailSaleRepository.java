package com.CidenetShop.CidenetShopBackend.repository;

import com.CidenetShop.CidenetShopBackend.model.DetailSale;
import com.CidenetShop.CidenetShopBackend.model.DetailSalePkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailSaleRepository extends JpaRepository<DetailSale, DetailSalePkId> {

}
