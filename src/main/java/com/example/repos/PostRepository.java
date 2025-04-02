package com.example.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.models.Post;

public interface PostRepository{
    Page<Post> findAll(Pageable pageable);
}
