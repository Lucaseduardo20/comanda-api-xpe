package com.lucas.command.controller;

import com.lucas.command.model.Product;
import com.lucas.command.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        return productService.list();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> find(@PathVariable Long id) {
        return productService.find(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }
    
    @GetMapping("/count")
    public long count() {
        return productService.count();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}


