package com.example.blogapi.convert;

import com.example.blogapi.dto.NotificationDTO;
import com.example.blogapi.entity.NotificationEntity;
import org.springframework.stereotype.Component;

@Component
public class NotificationConvert {

    public NotificationDTO toDTO (NotificationEntity entity) {
        NotificationDTO notificationPostDTO = new NotificationDTO();
        notificationPostDTO.setIdUser(entity.getIdUser());
        notificationPostDTO.setIdPost(entity.getIdPost());
        notificationPostDTO.setType(entity.getType());
        notificationPostDTO.setId(entity.getId());
        notificationPostDTO.setCreatedDate(entity.getCreatedDate());
        notificationPostDTO.setModifileDate(entity.getModifileDate());

        return notificationPostDTO;
    }

    public NotificationEntity toEntity (NotificationDTO dto) {
        NotificationEntity notificationPostEntity = new NotificationEntity();
        notificationPostEntity.setIdPost(dto.getIdPost());
        notificationPostEntity.setIdUser(dto.getIdUser());
        notificationPostEntity.setType(dto.getType());

        return notificationPostEntity;
    }
}
