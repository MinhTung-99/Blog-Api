package com.example.blogapi.repository;

import com.example.blogapi.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    CommentEntity findOneById(Long idComment);
}
