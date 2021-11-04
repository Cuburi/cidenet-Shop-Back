package com.CidenetShop.CidenetShopBackend.repository;

import com.CidenetShop.CidenetShopBackend.model.Detalle_Talla;
import com.CidenetShop.CidenetShopBackend.model.Detalle_TallaPKId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_TallaRepository extends JpaRepository<Detalle_Talla, Detalle_TallaPKId> {
}
