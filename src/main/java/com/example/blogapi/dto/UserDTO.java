package com.example.blogapi.dto;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String avatar;
    private String typeUser;
    private String ranker;
}
