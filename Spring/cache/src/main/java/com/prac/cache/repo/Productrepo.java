package com.prac.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cache.Entity.Product;

public interface Productrepo extends JpaRepository<Product, Integer>{

}
