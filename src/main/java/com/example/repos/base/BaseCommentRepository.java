package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Comment;

@Repository
public interface BaseCommentRepository extends JpaRepository<Comment, Integer>{

}