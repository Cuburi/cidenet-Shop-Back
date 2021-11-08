package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.criteria.ProductCriteria;
import com.CidenetShop.CidenetShopBackend.model.Product;
import com.CidenetShop.CidenetShopBackend.model.Product_;
import com.CidenetShop.CidenetShopBackend.model.Color_;
import com.CidenetShop.CidenetShopBackend.repository.ProductRepository;
import io.github.jhipster.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.JoinType;
import java.util.List;

@Service
@Transactional
public class ProductService extends QueryService <Product> {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findByCriteria(ProductCriteria productCriteria){
        final Specification<Product> specification = createSpecification(productCriteria);
        List<Product> products = productRepository.findAll(specification);
        return products;
    }

    private Specification<Product> createSpecification(ProductCriteria criteria){
        Specification<Product> specification = Specification.where(null);
        if (criteria != null){

           if (criteria.getDescription() != null){
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Product_.description));
            }

            if(criteria.getBrand() != null){
                specification = specification.and(buildStringSpecification(criteria.getBrand(), Product_.brand));
            }


            if(criteria.getColor() != null){
                specification =
                        specification.and(buildSpecification(criteria.getColor(),root -> root.join(Product_.color, JoinType.LEFT).get(Color_.name)));
            }
        }
        return specification;
    }
}
