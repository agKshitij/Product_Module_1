package com.example.product.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SubCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subCategoryId;
	
	@Column(name="subCategoryName", length = 50, nullable = false)
	private String subCategoryName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@OneToMany(mappedBy="subCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> product;

	

	


	public SubCategory(Long subCategoryId, String subCategoryName, List<Product> product) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.product = product;
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
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}

	
	

}
