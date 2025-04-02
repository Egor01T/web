package com.example.services.dto;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

public class LikeDTO {
    private int id;
    private String post;
    private String user;
    private boolean isLike;
    private ZonedDateTime createdAt;

    public LikeDTO(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @NotEmpty
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    @NotEmpty
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public boolean isLike() {
        return isLike;
    }
    public void setLike(boolean isLike) {
        this.isLike = isLike;
    }

    @PastOrPresent
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
