package com.example.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Post;
import com.example.services.impl.PostServiceImpl;
import com.example.views.PostRowViewModel;

@Controller
@RequestMapping("/posts")
public class PostController {
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
}
