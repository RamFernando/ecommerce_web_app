package com.ramesha.ecommerce.model;

import com.ramesha.ecommerce.commonmodel.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Category")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String categoryname;

    @Transient
    Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

}
