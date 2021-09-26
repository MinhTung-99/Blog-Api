package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_love_comment")
@Data
public class UserLoveCommentEntity extends BaseEntity {

    @Column private Long idUser;
    @Column private Long idPost;
    @Column private Long idComment;
}
