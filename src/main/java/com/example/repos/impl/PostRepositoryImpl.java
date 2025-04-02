package com.example.repos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.models.Post;
import com.example.repos.PostRepository;
import com.example.repos.base.BasePostRepository;

@Repository
public class PostRepositoryImpl implements PostRepository{

    @Autowired
    private BasePostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
    
}
