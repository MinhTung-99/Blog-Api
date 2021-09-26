package com.example.blogapi.dto;

import lombok.Data;

@Data
public class UserLoveDTO extends BaseDTO {
    private Long idUser;
    private Long idPost;
}
