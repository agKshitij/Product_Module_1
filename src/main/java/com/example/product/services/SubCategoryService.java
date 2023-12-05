package com.example.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Category;
import com.example.product.entity.SubCategory;
import com.example.product.repositories.CategoryRepository;
import com.example.product.repositories.SubCategoryRepository;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubCategoryService implements SubCategoryServiceInterface {
	
	@Autowired
    private SubCategoryRepository subCategoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getSubCategoryById(Long subCategoryId) {
        return subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new EntityNotFoundException("Sub Category not found with id: " + subCategoryId));
    }

    public String createSubCategory(SubCategory subCategory, Long categoryId) {
    	Category c = categoryRepository.findById(categoryId).get();
    	if(c != null) {
    		subCategory.setCategory(c);
    		subCategoryRepository.save(subCategory);
    		return "SubCategory Created Successfully";
    	}
    	else        
    		return "SubCategory Not Created Successfully";
    }

    public String updateSubCategory(Long subCategoryId, SubCategory updatedSubCategory) {
        SubCategory existingSubCategory = getSubCategoryById(subCategoryId);
        // Update existingSubCategory fields with updatedSubCategory fields
        if(existingSubCategory != null) {
        	existingSubCategory.setSubCategoryName(updatedSubCategory.getSubCategoryName());
        	subCategoryRepository.save(existingSubCategory);
            return "SubCategory is Updated Successfully";
        }
        else
        	return "SubCategory is Not Updated Successfully";
        
    }

    public String deleteSubCategory(Long subCategoryId) {
        SubCategory existingSubCategory = getSubCategoryById(subCategoryId);
        subCategoryRepository.delete(existingSubCategory);
        return "SubCategory Deleted Successfully";
    }


}
