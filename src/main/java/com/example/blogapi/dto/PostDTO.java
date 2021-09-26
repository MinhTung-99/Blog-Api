package com.example.blogapi.dto;

import lombok.Data;

@Data
public class PostDTO extends BaseDTO {

    public PostDTO() {
        user = new User();
    }

    private Long idUser;
    private Long idCategory;
    private User user;
    private String title;
    private String image;
    private String audio;
    private String content;
    private Long numView;
    private Long numComment;
    private Long numLove;
    private Boolean isLove;

    @Data
    public class User {
        private String firstName;
        private String lastName;
    }
}