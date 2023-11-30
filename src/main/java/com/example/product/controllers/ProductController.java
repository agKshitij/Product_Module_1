package com.example.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.services.ProductService;

@RestController // request handling method
@RequestMapping("/api/products") // used to map requests to controllers methods
public class ProductController {
	
	@Autowired // is to inject the object dependency
    private ProductService productService;

    @GetMapping("/ListOfProduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/GetProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
    	Product p = productService.getProductById(productId);
    	return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
    
    @PostMapping("/CreateProduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
    	String s = productService.createProduct(product);
    	return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @PutMapping("/UpdateProduct/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        String u = productService.updateProduct(productId, updatedProduct);
        return new ResponseEntity<String>(u, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        String msg = productService.deleteProduct(productId);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    
	
}
