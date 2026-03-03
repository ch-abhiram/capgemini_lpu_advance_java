package com.prac.cache.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.cache.Entity.Product;
import com.prac.cache.Service.ProductService;

@RestController
public class ProductController {
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	@GetMapping("/find/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getById(id);
	}

}
