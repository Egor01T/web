package com.example.repos.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Subscribe;

public interface BaseSubscribeRepository extends JpaRepository<Subscribe,Integer>{
    Page<Subscribe> findBySubscribedUserUsername(String username,Pageable pageable);
    boolean existsByIdAndSubscribedUserUsername(int id,String subscribedUserUsername);
    boolean existsByUserUsernameAndSubscribedUserUsername(String userUsername,String subscribedUserUsername);
}
