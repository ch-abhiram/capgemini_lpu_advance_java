package com.capgemini.task.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.task.Entity.Category;
import com.capgemini.task.Entity.Product;
import com.capgemini.task.Exception.CategoryNotFoundException;
import com.capgemini.task.Exception.InvalidProductDataException;
import com.capgemini.task.Exception.ProductNotFoundException;
import com.capgemini.task.Repository.CategoryRepository;
import com.capgemini.task.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(Product product, Long categoryId) {

        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new InvalidProductDataException("Product name cannot be empty");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        product.setCategory(category);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId);
    }

    public List<Product> searchProductByName(String name) {
        return productRepository.findByProductNameContaining(name);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setProductName(updatedProduct.getProductName());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

}
