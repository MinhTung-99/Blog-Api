package com.example.blogapi.repository;

import com.example.blogapi.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    CourseEntity findOneById(Long idCourse);
}
