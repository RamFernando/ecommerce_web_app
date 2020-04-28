package com.ramesha.ecommerce.productservice.controller;

import com.ramesha.ecommerce.productservice.model.Product;
import com.ramesha.ecommerce.productservice.repository.ProductRepository;
import com.ramesha.ecommerce.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/test")
    public String test(){
        return "Hello Product";
    }

    @RequestMapping(value = "/product/save",method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/product/:{id}")
    public Object getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @RequestMapping(value="/product/category/{id}")
    public List<Product> productsByCatId(@PathVariable Integer id){
        List<Product> products = productService.getAllProductsByCatId(id);
        return products;
    }

    @RequestMapping(value = "/product/getAll")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }

    @RequestMapping("/product/removeQty")
    public Product removeQty(@RequestParam Integer id, @RequestParam int qty){
        return productService.removeQty(id,qty);
    }
}
