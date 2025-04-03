package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Subscribe;

public interface BaseSubscribeRepository extends JpaRepository<Subscribe,Integer>{
    
}
