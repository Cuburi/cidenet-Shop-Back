package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.criteria.ProductCriteria;
import com.CidenetShop.CidenetShopBackend.model.*;
import com.CidenetShop.CidenetShopBackend.repository.ProductRepository;
import io.github.jhipster.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.JoinType;
import java.util.*;

@Service
@Transactional
public class ProductService extends QueryService <Product> {

    @Autowired
    ProductRepository productRepository;

    public boolean existsByName(String name){
        return productRepository.existsByName(name);
    }

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
                specification =
                        specification.and(buildSpecification(criteria.getBrand(),root -> root.join(Product_.brand, JoinType.LEFT).get(Brand_.name)));
            }

            if(criteria.getColor() != null){
                specification =
                        specification.and(buildSpecification(criteria.getColor(),root -> root.join(Product_.color, JoinType.LEFT).get(Color_.name)));
            }

            if(criteria.getSection() != null){
                specification =
                        specification.and(buildSpecification(criteria.getSection(),root -> root.join(Product_.section, JoinType.LEFT).get(Section_.name)));
            }
        }
        return specification;
    }

    public List<Product> findAll (){
        return productRepository.findAll();
    }

    public void findAllByTop (List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return new Integer(p2.getAccountVisit()).compareTo(new Integer(p1.getAccountVisit()));
            }
        });
    }

    public void findAllByActive (List<Product> products){
        products.removeIf(product -> !product.isActive());
    }

    public boolean existById (Long id){
        return productRepository.existsById(id);
    }
    public Optional<Product> getOne(Long idProduct){
        return productRepository.findById(idProduct);
    }

    public void  save(Product product){
        productRepository.save(product);
    }

}
