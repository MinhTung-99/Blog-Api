package com.example.blogapi.repository;


import com.example.blogapi.entity.UserJoinCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJoinCourseRepository extends JpaRepository<UserJoinCourseEntity, Long> {
}
