package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Post;

@Repository
public interface BasePostRepository extends JpaRepository<Post, Integer>{
}
