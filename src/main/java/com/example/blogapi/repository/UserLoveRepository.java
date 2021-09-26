package com.example.blogapi.repository;

import com.example.blogapi.entity.UserLoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoveRepository extends JpaRepository<UserLoveEntity, Long> {
}
