package com.CidenetShop.CidenetShopBackend.repository;

import com.CidenetShop.CidenetShopBackend.model.DetailSize;
import com.CidenetShop.CidenetShopBackend.model.DetailSizePkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailSizeRepository extends JpaRepository<DetailSize, DetailSizePkId> {
    Optional<List<DetailSize>> findByIdProduct(Long idProduct);
    boolean existsByIdProduct(Long idProductLong);
    boolean existsById(DetailSizePkId idDetailSize);

}
