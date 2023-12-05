package com.example.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;


@EnableJpaRepositories
@Repository // class provides the mechanism for update, delete and search operation on objects
public interface ProductRepository extends JpaRepository<Product, Long>{
	
//	@Query("select p from Product p where p.productName = :productName")
//	Product findByName(String productName); // JPA contains the APIs for basic CRUD operations
	
//	@Query("delete p from Product p where p.productName = :productName")
//	public void deleteByProductName(String productName);

}
