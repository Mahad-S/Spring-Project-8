package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// This interface handles all database operations for Product
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by name
    List<Product> findByName(String name);

    // Find products by category id
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    // Find products where quantity is below a certain number
    @Query("SELECT p FROM Product p WHERE p.quantity < :threshold")
    List<Product> findLowStock(@Param("threshold") int threshold);
}