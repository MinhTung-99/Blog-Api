package com.example.blogapi.convert;

import com.example.blogapi.dto.UserLoveDTO;
import com.example.blogapi.entity.UserLoveEntity;
import org.springframework.stereotype.Component;

@Component
public class UserLoveConvert {

    public UserLoveDTO toDTO (UserLoveEntity userLoveEntity) {
        UserLoveDTO userLoveDTO = new UserLoveDTO();
        userLoveDTO.setIdUser(userLoveEntity.getIdUser());
        userLoveDTO.setIdPost(userLoveEntity.getIdPost());

        return userLoveDTO;
    }

    public UserLoveEntity toEntity (UserLoveDTO userLoveDTO) {
        UserLoveEntity userLoveEntity = new UserLoveEntity();
        userLoveEntity.setIdPost(userLoveDTO.getIdPost());
        userLoveEntity.setIdUser(userLoveDTO.getIdUser());

        return userLoveEntity;
    }
}
