package com.example.blogapi.dto;

import com.example.blogapi.entity.BaseEntity;
import lombok.Data;

@Data
public class CourseDTO extends BaseEntity {
    private String name;
    private Long totalUser;
    private String image;
    private String description;
    private Boolean isJoin;
}