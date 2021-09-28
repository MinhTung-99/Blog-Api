package com.example.blogapi.convert;

import com.example.blogapi.dto.UserJoinCourseDTO;
import com.example.blogapi.entity.UserJoinCourseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserJoinCourseConvert {

    public UserJoinCourseDTO toDTO (UserJoinCourseEntity userJoinCourseEntity) {
        UserJoinCourseDTO userJoinCourseDTO = new UserJoinCourseDTO();
        userJoinCourseDTO.setIdCourse(userJoinCourseEntity.getIdCourse());
        userJoinCourseDTO.setIdUser(userJoinCourseEntity.getIdUser());

        return userJoinCourseDTO;
    }

    public UserJoinCourseEntity toEntity (UserJoinCourseDTO userJoinCourseDTO) {
        UserJoinCourseEntity userJoinCourseEntity = new UserJoinCourseEntity();
        userJoinCourseEntity.setIdCourse(userJoinCourseDTO.getIdCourse());
        userJoinCourseEntity.setIdUser(userJoinCourseDTO.getIdUser());

        return userJoinCourseEntity;
    }
}
