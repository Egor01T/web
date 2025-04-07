package com.example.repos.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;

@Repository
public interface BaseUserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
