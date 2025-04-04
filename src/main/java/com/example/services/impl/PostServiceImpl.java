package com.example.services.impl;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.models.Comment;
import com.example.models.Post;
import com.example.repos.base.BaseCommentRepository;
import com.example.repos.base.BaseLikeRepository;
import com.example.repos.base.BasePostRepository;
import com.example.utils.ValidationUtil;
import com.example.views.CommentViewModel;
import com.example.views.PostRowViewModel;
import com.example.views.PostViewModel;

@Service
public class PostServiceImpl {
    private final BaseLikeRepository likeRepository;
    private final BaseCommentRepository commentRepository;
    private final BasePostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PostServiceImpl(BasePostRepository postRepository, ModelMapper modelMapper, ValidationUtil validationUtil,BaseCommentRepository commentRepository,BaseLikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
     }
    
    public Page<PostRowViewModel> getPostsPage(Pageable pageable){
        Page<Post> pages = postRepository.findAll(pageable);
        return pages.map(entity -> modelMapper.map(entity,PostRowViewModel.class));
    }

    public PostViewModel getPostViewModel(int id,Pageable pageable){
        Optional<Post> post = postRepository.findById(id);
        Page<Comment> comments = commentRepository.findByPostIdOrderByCreatedAtDesc(id, pageable);
        int likes = likeRepository.countByPostIdAndIsLikeTrue(id);
        int dislikes = likeRepository.countByPostIdAndIsLikeFalse(id);
        PostViewModel viewModel = new PostViewModel();
        if (post.isEmpty()){
            return null;
        }
        viewModel.setId(id);
        viewModel.setUserUsername(post.get().getUser().getUsername());
        viewModel.setTitle(post.get().getTitle());
        viewModel.setText(post.get().getText());
        if(post.get().getUpdatedAt() != null){
            viewModel.setUpdatedAt(post.get().getUpdatedAt().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        }else if (post.get().getCreatedAt() != null){
            viewModel.setUpdatedAt(post.get().getCreatedAt().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        }
        viewModel.setLikes(likes);
        viewModel.setDislikes(dislikes);
        viewModel.setComments(comments.map(entity -> modelMapper.map(entity,CommentViewModel.class)));
        return viewModel;
    }
}
