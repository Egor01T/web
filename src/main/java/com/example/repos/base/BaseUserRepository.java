package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;

@Repository
public interface BaseUserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
