package com.example.blogapi.convert;

import com.example.blogapi.constant.RankerUtil;
import com.example.blogapi.dto.UserDTO;
import com.example.blogapi.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {

    public UserEntity toEntity (UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        userEntity.setName(dto.getName());
        userEntity.setPhoneNumber(dto.getPhoneNumber());
        userEntity.setAvatar(dto.getAvatar());
        userEntity.setRanker(RankerUtil.COPPER);

        return userEntity;
    }

    public UserDTO toDTO (UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setName(userEntity.getName());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        userDTO.setCreatedDate(userEntity.getCreatedDate());
        userDTO.setModifileDate(userEntity.getModifileDate());
        userDTO.setAvatar(userEntity.getAvatar());
        userDTO.setRanker(userEntity.getRanker());

        return userDTO;
    }
}
