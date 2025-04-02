package com.example.services;

import com.example.models.User;
import com.example.services.dto.UserDTO;

public interface UserService {
    void addUser(UserDTO userDTO);
    User findByUsername(String username);
}
