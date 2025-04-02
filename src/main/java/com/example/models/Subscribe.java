package com.example.models;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//unique user subscribed_user
@Entity
@Table(name = "subscriptions")
public class Subscribe extends BaseEntity{
    private User user;
    private User subscribedUser;
    private ZonedDateTime createdAt;

    public Subscribe(){}

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    public User getSubscribedUser() {
        return subscribedUser;
    }

    public void setSubscribedUser(User subscribedUser) {
        this.subscribedUser = subscribedUser;
    }

    @Column(name = "created_at", nullable = false)
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
