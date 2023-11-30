package com.example.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SubCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subCategoryId;
	
	@Column(name="custFName", length = 15,nullable = false)
	private String subCategoryName;
	
	@ManyToOne
	private Category category;

	

	public SubCategory(Long subCategoryId, String subCategoryName) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
	}
	
	public SubCategory() {
		
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	
	

}
