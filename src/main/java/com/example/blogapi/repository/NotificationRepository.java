package com.example.blogapi.repository;

import com.example.blogapi.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
