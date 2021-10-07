package com.example.blogapi.convert;

import com.example.blogapi.constant.NotificationUtil;
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
            notificationPostEntity.setType(NotificationUtil.TYPE_POST);
        }
        if (dto.getIdCourse() != null) {
            notificationPostEntity.setIdCourse(dto.getIdCourse());
            notificationPostEntity.setType(NotificationUtil.TYPE_COURSE);
        }
        if (dto.getIdComment() != null && dto.getIdPost() != null) {
            notificationPostEntity.setIdComment(dto.getIdComment());
            notificationPostEntity.setType(NotificationUtil.TYPE_COMMENT);
        }
        notificationPostEntity.setIdUser(dto.getIdUser());

        return notificationPostEntity;
    }
}
