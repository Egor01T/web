package com.example.services.dto;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

public class SubscribeDTO {
    private int id;
    private String user;
    private String subscribedUser;
    private ZonedDateTime createdAt;

    public SubscribeDTO(){}

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
    public String getSubscribedUser() {
        return subscribedUser;
    }
    public void setSubscribedUser(String subscribedUser) {
        this.subscribedUser = subscribedUser;
    }

    @PastOrPresent
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    } 
}
