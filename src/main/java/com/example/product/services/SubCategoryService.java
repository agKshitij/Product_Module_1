package com.example.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Category;
import com.example.product.repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubCategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Category updatedCategory) {
        Category existingCategory = getCategoryById(categoryId);
        // Update existingCategory fields with updatedCategory fields
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long categoryId) {
        Category existingCategory = getCategoryById(categoryId);
        categoryRepository.delete(existingCategory);
    }

}
