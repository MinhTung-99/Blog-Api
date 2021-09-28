package com.example.blogapi.dto;

import com.example.blogapi.entity.BaseEntity;
import lombok.Data;

@Data
public class UserJoinCourseDTO extends BaseEntity {

    private Long idCourse;
    private Long idUser;
}
