package com.example.services.dto;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class CommentDTO {
    private int id;
    private String user;
    private String post;
    private String text;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public CommentDTO(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    @NotEmpty
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    @NotNull
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @PastOrPresent
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
