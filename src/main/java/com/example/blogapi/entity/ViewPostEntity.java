package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "view_post")
@Data
public class ViewPostEntity extends BaseEntity {
    @Column private Long idPost;
    @Column private Long idUser;
}
