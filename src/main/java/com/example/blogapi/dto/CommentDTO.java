package com.example.blogapi.dto;

import lombok.Data;

@Data
public class CommentDTO extends BaseDTO {

    private Long idPost;
    private Long idUser;
    private String description;
    private Long totalLove;
    private Boolean isLove;
}
