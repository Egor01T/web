package com.example.repos;

import com.example.models.User;

public interface UserRepository{
    User findByUsername(String username);
    void saveAndFlush(User user);
}
