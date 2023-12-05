package com.example.product.services;

import java.util.List;

import com.example.product.entity.SubCategory;

public interface SubCategoryServiceInterface {
	
	List<SubCategory> getAllSubCategories();
	
	SubCategory getSubCategoryById(Long subCategoryId);
	
	String createSubCategory(SubCategory subCategory, Long categoryId);
	
	String updateSubCategory(Long subCategoryId, SubCategory updatedSubCategory);
	
	String deleteSubCategory(Long subCategoryId);

}
