package com.CidenetShop.CidenetShopBackend.repository;

import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.model.DetailSizePkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailSizeRepository extends JpaRepository<DetailSize, DetailSizePkId> {
}
