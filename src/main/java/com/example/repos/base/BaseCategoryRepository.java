package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Category;

@Repository
public interface BaseCategoryRepository extends JpaRepository<Category, Integer>{
    
}
