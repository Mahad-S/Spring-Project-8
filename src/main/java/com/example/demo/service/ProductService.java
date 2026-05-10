package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create
    public Product create(Product product) {
        return productRepository.save(product);
    }

    // Read all
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // Read by id
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    // Read by name
    public List<Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    // Read by category
    public List<Product> getByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    // Read low stock
    public List<Product> getLowStock(int threshold) {
        return productRepository.findLowStock(threshold);
    }

    // Update
    public Product update(Product product) {
        return productRepository.save(product);
    }

    // Delete
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}