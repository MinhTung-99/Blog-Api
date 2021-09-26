package com.example.blogapi.repository;

import com.example.blogapi.entity.UserLoveCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentLoveRepository extends JpaRepository<UserLoveCommentEntity, Long> {

}