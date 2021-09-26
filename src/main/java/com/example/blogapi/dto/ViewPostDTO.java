package com.example.blogapi.dto;

import lombok.Data;

@Data
public class ViewPostDTO extends BaseDTO {
    private Long idPost;
    private Long idUser;
}
