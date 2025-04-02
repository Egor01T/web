package com.example.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Post;
import com.example.services.PostService;

@Controller
@RequestMapping("/crud/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String listPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
        ){
        //Переработать Post на PostViewModel и доработать интерфейс сервиса!!!
        Page<Post> posts = postService.findAll(PageRequest.of(page, size));
        model.addAttribute("posts", posts);
        return "crud/posts/list";
    }
}
