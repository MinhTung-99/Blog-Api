package com.example.blogapi.convert;

import com.example.blogapi.dto.UserLoveCommentDTO;
import com.example.blogapi.entity.UserLoveCommentEntity;
import org.springframework.stereotype.Component;

@Component
public class UserLoveCommentConvert {

    public UserLoveCommentDTO toDTO (UserLoveCommentEntity userLoveCommentEntity) {
        UserLoveCommentDTO userLoveCommentDTO = new UserLoveCommentDTO();
        userLoveCommentDTO.setIdUser(userLoveCommentEntity.getIdUser());
        userLoveCommentDTO.setIdPost(userLoveCommentEntity.getIdPost());
        userLoveCommentDTO.setIdComment(userLoveCommentEntity.getIdComment());

        return userLoveCommentDTO;
    }

    public UserLoveCommentEntity toEntity (UserLoveCommentDTO userLoveCommentDTO) {
        UserLoveCommentEntity userLoveCommentEntity = new UserLoveCommentEntity();
        userLoveCommentEntity.setIdUser(userLoveCommentDTO.getIdUser());
        userLoveCommentEntity.setIdPost(userLoveCommentDTO.getIdPost());
        userLoveCommentEntity.setIdComment(userLoveCommentDTO.getIdComment());

        return userLoveCommentEntity;
    }
}
