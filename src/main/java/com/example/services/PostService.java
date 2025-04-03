package com.example.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.example.models.Post;
import com.example.views.PostRowViewModel;

public interface PostService {
    public Page<Post> findAll(Pageable pageable);
    public Page<PostRowViewModel> getViewModelPage(Pageable pageable);
}
