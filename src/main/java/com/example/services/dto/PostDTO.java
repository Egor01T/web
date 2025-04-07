package com.example.services.dto;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class PostDTO {
    private int id;
    private String user;
    private String title;
    private String text;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String category;

    public PostDTO(){}

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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
        this.updatedAt = createdAt;
    }


    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
}
