package com.example.repos.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.Like;

@Repository
public interface BaseLikeRepository extends JpaRepository<Like, Integer>{
    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.id = :postId AND l.isLike = true")
    int countByPostIdAndIsLikeTrue(int postId);  // Лайки

    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.id = :postId AND l.isLike = false")
    int countByPostIdAndIsLikeFalse(int postId); // Дизлайки
}
