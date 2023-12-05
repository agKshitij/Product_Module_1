package com.example.product.services;

import java.util.List;

import com.example.product.entity.Category;

public interface CategoryServiceInterface {
	
	List<Category> getAllCategories();
	
	Category getCategoryById(Long categoryId);
	
	String createCategory(Category category);
	
	String updateCategory(Long categoryId, Category updatedCategory);
	
	String deleteCategory(Long categoryId);

}
