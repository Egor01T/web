package com.example.repos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.User;
import com.example.repos.UserRepository;
import com.example.repos.base.BaseUserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private BaseUserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveAndFlush(User user) {
        userRepository.saveAndFlush(user);
    }
    
}
