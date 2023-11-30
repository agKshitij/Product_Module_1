package com.example.product.services;

import java.util.List;

import com.example.product.entity.Product;

public interface ProductServiceInterface {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long productId);
	
	String createProduct(Product product);
	
	String updateProduct(Long productId, Product updatedProduct);
	
	String deleteProduct(Long productId);

}
