package com.ramesha.ecommerce.productservice.repository;

import com.ramesha.ecommerce.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findByCatid(Integer catid);
}
