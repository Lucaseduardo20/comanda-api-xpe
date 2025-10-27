package com.lucas.comanda.service;

import com.lucas.comanda.repository.ProductRepository;
import com.lucas.comanda.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRespository;

    public List<Product> list() {
        return productRespository.findAll();
    }

    public Optional<Product> find(Long id) {
        return productRespository.findById(id);
    }

    public List<Product> findByName(String name) {
        return productRespository.findByName(name);
    }

    public Product save(Product product) {
        return productRespository.save(product);
    }

    public void delete(Long id) {
        productRespository.deleteById(id);
    }

    public long count() {
        return productRespository.count();
    }
}