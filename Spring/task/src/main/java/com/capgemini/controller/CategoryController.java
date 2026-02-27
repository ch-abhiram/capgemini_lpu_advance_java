package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.task.Entity.Category;
import com.capgemini.task.Service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	 @PostMapping("/add")
	 public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	 }
	 
	 @GetMapping("/get")
	  public List<Category> getAllCategories() {
	        return categoryService.getAllCategories();
	  }
	 
	 @PutMapping("/update/{id}")
	 public Category updateCategory(@PathVariable Long id,
	                                   @RequestBody Category category) {
	        return categoryService.updateCategory(id, category);
	 }

	 @DeleteMapping("/delete/{id}")
	 public String deleteCategory(@PathVariable Long id) {
	        categoryService.delete(id);
	        return "Category deleted successfully";
	 }
	
}
