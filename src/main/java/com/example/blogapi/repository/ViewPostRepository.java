package com.example.blogapi.repository;

import com.example.blogapi.entity.ViewPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewPostRepository extends JpaRepository<ViewPostEntity, Long> {

    ViewPostEntity findOneByIdUser (Long idUser);
}