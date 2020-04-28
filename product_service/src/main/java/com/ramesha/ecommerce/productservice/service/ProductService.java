package com.ramesha.ecommerce.productservice.service;

import com.ramesha.ecommerce.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Object getById(Integer id);
    List<Product> getAllProductsByCatId(Integer id);
    List<Product> getAll();
    Product removeQty(Integer id, int qty);
}
