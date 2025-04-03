package com.example.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.models.Post;
import com.example.repos.base.BasePostRepository;
import com.example.utils.ValidationUtil;
import com.example.views.PostRowViewModel;

@Service
public class PostServiceImpl {
    private final BasePostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PostServiceImpl(BasePostRepository postRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }
    
    public Page<PostRowViewModel> getPostsPage(Pageable pageable){
        Page<Post> pages = postRepository.findAll(pageable);
        return pages.map(entity -> modelMapper.map(entity,PostRowViewModel.class));
    }
}
