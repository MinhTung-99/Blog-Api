package com.example.blogapi.dto;

import lombok.Data;

@Data
public class NotificationDTO extends BaseDTO {

    public NotificationDTO() {
        user = new User();
    }

    private Long idPost;
    private Long idUser;
    private Long idComment;
    private Long idCourse;
    private String type;
    private User user;

    @Data
    public class User {
        private String name;
        private String avatar;
    }
}
