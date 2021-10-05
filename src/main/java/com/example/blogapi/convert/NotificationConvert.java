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
        notificationPostDTO.setIdComment(entity.getIdComment());
        notificationPostDTO.setIdCourse(entity.getIdCourse());

        return notificationPostDTO;
    }

    public NotificationEntity toEntity (NotificationDTO dto) {
        NotificationEntity notificationPostEntity = new NotificationEntity();
        if (dto.getIdPost() != null) {
            notificationPostEntity.setIdPost(dto.getIdPost());
        }
        if (dto.getIdCourse() != null) {
            notificationPostEntity.setIdCourse(dto.getIdCourse());
        }
        if (dto.getIdComment() != null) {
            notificationPostEntity.setIdComment(dto.getIdComment());
        }
        notificationPostEntity.setIdUser(dto.getIdUser());
        notificationPostEntity.setType(dto.getType());

        return notificationPostEntity;
    }
}
