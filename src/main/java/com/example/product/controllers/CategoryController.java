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

import com.example.product.entity.Category;

import com.example.product.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/ListOfCategory")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @GetMapping("/GetCategoryById/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
    	Category p = categoryService.getCategoryById(categoryId);
    	return new ResponseEntity<Category>(p, HttpStatus.OK);
    }
    
    @PostMapping("/CreateCategory")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
    	String s = categoryService.createCategory(category);
    	return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @PutMapping("/UpdateCategory/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryId, @RequestBody Category updatedCategory) {
        String c = categoryService.updateCategory(categoryId, updatedCategory);
        return new ResponseEntity<String>(c, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        String msg = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

}
