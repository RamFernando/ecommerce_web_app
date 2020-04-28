package com.ramesha.ecommerce.productservice.service;

import com.ramesha.ecommerce.productservice.model.Product;
import com.ramesha.ecommerce.productservice.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Object getById(Integer id) {
        if (productRepository.existsById(id)) {
            return productRepository.findById(id);
        }
        return "No product found by this id";
    }

    @Override
    public List<Product> getAllProductsByCatId(Integer id) {

        List<Product> all = productRepository.findByCatid(id);
        return all;
    }

    @Override
    public List<Product> getAll() {
        System.out.println("GET ALL CALLED");
        return productRepository.findAll();
    }

    @Override
    public Product removeQty(Integer id, int qty) {
        Optional<Product> product = productRepository.findById(id);
        Product product1 = product.get();

        product1.setQty(product1.getQty()-qty);

        return productRepository.save(product1);
    }

}
