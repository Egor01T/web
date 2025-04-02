package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Tag;

@Repository
public interface BaseTagRepository extends JpaRepository<Tag, Integer>{
    
}
