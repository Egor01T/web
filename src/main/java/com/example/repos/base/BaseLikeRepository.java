package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Like;

@Repository
public interface BaseLikeRepository extends JpaRepository<Like, Integer>{
    
}
