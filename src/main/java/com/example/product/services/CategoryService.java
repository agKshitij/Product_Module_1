package com.example.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Category;
import com.example.product.repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService implements CategoryServiceInterface {
	
	@Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));
    }

    public String createCategory(Category category) {
    	categoryRepository.save(category);
        return "Category is Successfully Added";
    }

    public String updateCategory(Long categoryId, Category updatedCategory) {
        Category existingCategory = getCategoryById(categoryId);
        // Update existingCategory fields with updatedCategory fields
        if(existingCategory != null) {
        	existingCategory.setCategoryName(updatedCategory.getCategoryName());
        	existingCategory.setCategoryActiveStatus(updatedCategory.getCategoryActiveStatus());
        	existingCategory.setCategoryDescription(updatedCategory.getCategoryDescription());
        	
        	categoryRepository.save(existingCategory);
        	return "Category is Updated Successfully";        	
        }
        else
        	return "Catgeory is Not Updated";
    }

    public String deleteCategory(Long categoryId) {
        Category existingCategory = getCategoryById(categoryId);
        if(existingCategory != null) {
        	categoryRepository.deleteById(categoryId);
        	return "Category is Deleted";
        }  
        else {
        	return "Catgeory Not Found";
        }
        
    }

}
