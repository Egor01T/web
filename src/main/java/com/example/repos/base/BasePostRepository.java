package com.example.repos.base;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Post;
import com.example.models.User;

@Repository
public interface BasePostRepository extends JpaRepository<Post, Integer>{
    Page<Post> findByUserUsername(String username,Pageable pageable);
        
    @Query("SELECT p.user FROM Post p WHERE p.id = :postId")
    Optional<User> findUserByPostId(@Param("postId") int postId);
}
