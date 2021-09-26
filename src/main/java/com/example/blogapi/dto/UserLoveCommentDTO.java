package com.example.blogapi.dto;

import lombok.Data;

@Data
public class UserLoveCommentDTO extends BaseDTO {
    private Long idUser;
    private Long idPost;
    private Long idComment;
}
