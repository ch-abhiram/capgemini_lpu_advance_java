package com.capgemini.task.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.task.Entity.Category;
import com.capgemini.task.Exception.CategoryNotFoundException;
import com.capgemini.task.Repository.CategoryRepository;
@Service
public class CategoryService {
	@Autowired
	private CategoryRepository jpa;
	
	public Category createCategory(Category c) {
		return jpa.save(c);
	}
	
	public List<Category> getAllCategories(){
		return jpa.findAll();
	}
	
	public Category getCategoryById(Long id) {
		return jpa.findById(id).orElseThrow(()->
		new CategoryNotFoundException("Category not found"));
	}
	
	public void delete(Long id) {
		Category obj = getCategoryById(id);
		jpa.delete(obj);
	}
	
	public Category updateCategory(Long id, Category updateCategory) {
		Category category = getCategoryById(id);
		category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        return jpa.save(category);
	}
	
	
	
	
	
	
	

}
