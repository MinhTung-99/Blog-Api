package com.example.blogapi.repository;

import com.example.blogapi.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    PostEntity findOneById(Long idPost);
}
