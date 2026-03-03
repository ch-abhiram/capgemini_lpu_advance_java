package com.prac.cache.Service;

import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prac.cache.Entity.Product;
import com.prac.cache.repo.Productrepo;

@Service
public class ProductService {
	
	private Productrepo jpa;
	
	public ProductService(Productrepo jpa) {
		this.jpa = jpa;
	}
	@CachePut(cacheNames = "product" , key = "#result.id")
	public Product addProduct(Product p) {
		return jpa.save(p);
	}
	@Cacheable(cacheNames = "product" , key = "#id")
	public Product getById(int id) {
		return jpa.findById(id).orElseThrow(()->new RuntimeException("Id not present"));
	}
	
	public void deletePro(int id) {
		Optional<Product> obj = jpa.findById(id);
		if(obj.isPresent()) {
			jpa.deleteById(id);
			
		}
	}

}
