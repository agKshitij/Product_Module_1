package com.example.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional // database operations performed within the marked method 
public class ProductService implements ProductServiceInterface{
	
	@Autowired
	private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
        		.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }

    public String createProduct(Product product) {
        productRepository.save(product);
        return "Product is Successfully Added";
    }

    public String updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = getProductById(productId);
        // Update existingProduct fields with updatedProduct fields
        if(existingProduct != null){
        	existingProduct.setProductName(updatedProduct.getProductName());
        	existingProduct.setProductDescription(updatedProduct.getProductDescription());
        	existingProduct.setProductImageUrl(updatedProduct.getProductDescription());
//        	existingProduct.setProductId(updatedProduct.getProductId());
        	existingProduct.setProductPrice(updatedProduct.getProductPrice());
        	existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
        	productRepository.save(existingProduct);
        	return "Product is Updated Successfully";
        }else
        	return "Product is not updated";
        
        
    }

    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "Product is Deleted";
    }

    

}
