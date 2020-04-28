package com.ramesha.ecommerce.service;

import com.ramesha.ecommerce.commonmodel.Product;
import com.ramesha.ecommerce.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category saveCategory(Category category);
    Optional<Category> getById(Integer id);
    List<Category> getAll();
//    Product getProductsById(Integer id);
}
