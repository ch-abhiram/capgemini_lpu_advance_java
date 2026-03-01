package com.capgemini.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.HMS.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
