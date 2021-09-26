package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_course_join")
@Data
public class UserJoinCourseEntity extends BaseEntity {

    @Column private Long idCourse;
    @Column private Long idUser;
}
