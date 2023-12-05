package com.example.product.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

	@Column(name="categoryName", length = 15,nullable = false)
    private String categoryName;

	@Column(name="categoryDescription", length = 15,nullable = false)
    private String categoryDescription;
	
	@Column(name="categoryActiveStatus", length = 15,nullable = false)
    private Boolean categoryActiveStatus;
    
//	
	@OneToMany(mappedBy="category", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubCategory> subCategory;
    
//    Constructors
    
    public Category(Long categoryId, String categoryName, String categoryDescription,
    		Boolean categoryActiveStatus, List<SubCategory> subCategory) {
    	super();
    	this.categoryId = categoryId;
    	this.categoryName = categoryName;
    	this.categoryDescription = categoryDescription;
    	this.categoryActiveStatus = categoryActiveStatus;
    	this.subCategory = subCategory;
    	
    }
    
    public Category() {
    	
    }
    
    // Getter and Setters

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Boolean getCategoryActiveStatus() {
		return categoryActiveStatus;
	}

	public void setCategoryActiveStatus(Boolean categoryActiveStatus) {
		this.categoryActiveStatus = categoryActiveStatus;
	}
}
