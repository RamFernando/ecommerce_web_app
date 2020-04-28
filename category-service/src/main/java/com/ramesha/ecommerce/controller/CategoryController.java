package com.ramesha.ecommerce.controller;

import com.ramesha.ecommerce.model.Category;
import com.ramesha.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/testCat")
    public String test(){
        return "Hello Category";
    }

    @RequestMapping("/category/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @RequestMapping("/category/{id}")
    public Optional<Category> getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @RequestMapping("/category/getAll")
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }
}