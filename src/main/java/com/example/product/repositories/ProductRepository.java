package com.example.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;

@Repository // class provides the mechanism for update, delete and search operation on objects
public interface ProductRepository extends JpaRepository<Product, Long>{ // JPA contains the APIs for basic CRUD operations

}
