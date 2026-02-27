package com.capgemini.task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.task.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
