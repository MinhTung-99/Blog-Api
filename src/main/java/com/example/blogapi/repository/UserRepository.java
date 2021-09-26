package com.example.blogapi.repository;

import com.example.blogapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findOneById(Long idUser);
}
