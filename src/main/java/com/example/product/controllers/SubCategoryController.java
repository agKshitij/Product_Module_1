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


import com.example.product.entity.SubCategory;

import com.example.product.services.SubCategoryService;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@GetMapping("/ListOfSubCategory")
    public ResponseEntity<List<SubCategory>> getAllCategory() {
        List<SubCategory> subCategories = subCategoryService.getAllSubCategories();
        return new ResponseEntity<List<SubCategory>>(subCategories, HttpStatus.OK);
    }

    @GetMapping("/GetSubCategoryById/{subCategoryId}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long subCategoryId) {
    	SubCategory p = subCategoryService.getSubCategoryById(subCategoryId);
    	return new ResponseEntity<SubCategory>(p, HttpStatus.OK);
    }
    
    @PostMapping("/CreateSubCategory/{categoryId}")
    public ResponseEntity<String> createSubCategory(@RequestBody SubCategory subCategory, @PathVariable Long categoryId) {
    	String s = subCategoryService.createSubCategory(subCategory, categoryId);
    	return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @PutMapping("/UpdateSubCategory/{subCategoryId}")
    public ResponseEntity<String> updateSubCategory(@PathVariable Long subCategoryId, @RequestBody SubCategory updatedSubCategory) {
        String c = subCategoryService.updateSubCategory(subCategoryId, updatedSubCategory);
        return new ResponseEntity<String>(c, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteSubCategory/{subCategoryId}")
    public ResponseEntity<String> deleteSubCategory(@PathVariable Long subCategoryId) {
        String msg = subCategoryService.deleteSubCategory(subCategoryId);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

}
