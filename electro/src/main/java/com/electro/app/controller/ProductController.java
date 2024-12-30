package com.electro.app.controller;

import com.electro.app.model.Product;
import com.electro.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}