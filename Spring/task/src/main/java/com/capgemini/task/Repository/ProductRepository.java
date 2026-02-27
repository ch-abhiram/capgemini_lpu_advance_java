package com.capgemini.task.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.task.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContaining(String name);

    List<Product> findByCategoryCategoryId(Long categoryId);
}