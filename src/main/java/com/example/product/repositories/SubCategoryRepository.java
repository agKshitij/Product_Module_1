package com.example.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>{

}
