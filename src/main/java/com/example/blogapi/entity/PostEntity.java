package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@Data
public class PostEntity extends BaseEntity {
    @Column private Long idUser;
    @Column private Long idCategory;
    @Column private String title;
    @Column private String image;
    @Column private String audio;
    @Column private String content;
    @Column private Long numView;
    @Column private Long numComment;
    @Column private Long numLove;
    @Column private Boolean isLove;
    @Column private Boolean isGroup;
    @Column private Long idGroup;
    @Column private String ranker;
}
