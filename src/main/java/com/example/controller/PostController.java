package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.services.impl.PostServiceImpl;
import com.example.views.PostRowViewModel;
import com.example.views.PostViewModel;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @GetMapping
    public String postsList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
        ){
        //Переработать Post на PostViewModel и доработать интерфейс сервиса!!!
        Page<PostRowViewModel> posts = postService.getPostsPage(PageRequest.of(page, size));
        model.addAttribute("posts", posts);
        return "posts_list";
    }

    @GetMapping("/post/{id}")
    public String getPost(
        @PathVariable int id,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        Model model
    ){
        PageRequest pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        PostViewModel postViewModel = postService.getPostViewModel(id, pageable);
        
        if (postViewModel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        
        model.addAttribute("post", postViewModel);
        return "post";
    }
}
