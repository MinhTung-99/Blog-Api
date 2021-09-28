package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@Data
public class CourseEntity extends BaseEntity {

    @Column private String name;
    @Column private Long totalUser;
    @Column private String image;
    @Column private String description;
    @Column private Boolean isJoin;
}
