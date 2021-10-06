package com.example.blogapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends BaseEntity {

    @Column private String email;
    @Column private String password;
    @Column private String firstName;
    @Column private String lastName;
    @Column private String avatar;
    @Column private String ranker;
    @Column private String typeUser;

}
