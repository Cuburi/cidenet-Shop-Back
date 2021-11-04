package com.CidenetShop.CidenetShopBackend.service;

import com.CidenetShop.CidenetShopBackend.criteria.ProductoCriteria;
import com.CidenetShop.CidenetShopBackend.model.Producto;
import com.CidenetShop.CidenetShopBackend.model.Producto_;
import com.CidenetShop.CidenetShopBackend.model.Color_;
import com.CidenetShop.CidenetShopBackend.repository.ProductoRepository;
import io.github.jhipster.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.JoinType;
import java.util.List;

@Service
@Transactional
public class ProductoService extends QueryService <Producto> {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> findByCriteria(ProductoCriteria productoCriteria){
        final Specification<Producto> specification = createSpecification(productoCriteria);
        List<Producto> productos = productoRepository.findAll(specification);
        return productos;
    }

    private Specification<Producto> createSpecification(ProductoCriteria criteria){
        Specification<Producto> specification = Specification.where(null);
        if (criteria != null){

           if (criteria.getDescripcion() != null){
                specification = specification.and(buildStringSpecification(criteria.getDescripcion(), Producto_.descripcion));
            }

            if(criteria.getMarca() != null){
                specification = specification.and(buildStringSpecification(criteria.getMarca(), Producto_.marca));
            }


            if(criteria.getColor() != null){
                specification =
                        specification.and(buildSpecification(criteria.getColor(),root -> root.join(Producto_.color, JoinType.LEFT).get(Color_.nombre)));
            }
        }
        return specification;
    }
}
