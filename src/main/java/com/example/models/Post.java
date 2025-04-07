package com.example.models;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{
    private User user;
    private String title;
    private String text;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Set<Comment> comments;

    public Post(){}

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "text", nullable = true, columnDefinition = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "created_at", nullable = false)
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = ZonedDateTime.now(ZoneId.systemDefault());
        // или конкретный часовой пояс:
        // createdAt = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
    }
}
