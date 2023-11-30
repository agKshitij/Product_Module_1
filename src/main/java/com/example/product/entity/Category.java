package com.example.product.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


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
    private long categoryActiveStatus;
    
    
//    Constructors
    
    public Category(Long categoryId, String categoryName, String categoryDescription,
    		long categoryActiveStatus) {
    	super();
    	this.categoryId = categoryId;
    	this.categoryName = categoryName;
    	this.categoryDescription = categoryDescription;
    	this.categoryActiveStatus = categoryActiveStatus;
    	
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

	public long getCategoryActiveStatus() {
		return categoryActiveStatus;
	}

	public void setCategoryActiveStatus(long categoryActiveStatus) {
		this.categoryActiveStatus = categoryActiveStatus;
	}
}
