package com.ramesha.ecommerce.service;

import com.ramesha.ecommerce.commonmodel.Product;
import com.ramesha.ecommerce.model.Category;
import com.ramesha.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
//
//    @Override
//    public List<Product> getProductsById(Integer id) {
//        Optional<Category> category = categoryRepository.findById(id);
//        if (category.isPresent()) {
//            HttpEntity<String> stringHttpEntity = new HttpEntity<>("", new HttpHeaders());
//
//            Category category1 = category.get();
//
//            ResponseEntity<Product[]> responseEntity = restTemplate.exchange(
//                    "http://localhost:8082/services/product/category/" + id, HttpMethod.GET, stringHttpEntity,
//                    Product[].class);
//            category1.setProducts(responseEntity.getBody());
//            return category1;
//        } else {
//            return null;
//        }
//    }
}
