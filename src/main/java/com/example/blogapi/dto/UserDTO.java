package com.example.blogapi.dto;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String typeUser;
}
