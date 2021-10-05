package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
@Data
public class NotificationEntity extends BaseEntity {
    private @Column Long idPost;
    private @Column Long idComment;
    private @Column Long idCourse;
    private @Column Long idUser;
    private @Column String type;
}
