package com.example.views;

import org.springframework.data.domain.Page;

public class PostViewModel {
    private int id;
    private String userUsername;
    private String title;
    private String text;
    private String updatedAt;
    private int likes;
    private int dislikes;
    private Page<CommentViewModel> comments;
    //TODO тэги
    //TODO комментарии
    public PostViewModel(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserUsername() {
        return userUsername;
    }
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public int getDislikes() {
        return dislikes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    public Page<CommentViewModel> getComments() {
        return comments;
    }
    public void setComments(Page<CommentViewModel> comments) {
        this.comments = comments;
    }
    
}
