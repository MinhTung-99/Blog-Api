package com.example.blogapi.service;

import com.example.blogapi.constant.NotificationUtil;
import com.example.blogapi.convert.NotificationConvert;
import com.example.blogapi.dto.NotificationDTO;
import com.example.blogapi.entity.NotificationEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.repository.NotificationRepository;
import com.example.blogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationConvert notificationPostConvert;

    public NotificationDTO save (NotificationDTO dto) {
        if (dto.getType().equals(NotificationUtil.TYPE_POST) || dto.getType().equals(NotificationUtil.TYPE_COMMENT)
                || dto.getType().equals(NotificationUtil.TYPE_COURSE)) {

            UserEntity userEntity = userRepository.findOneById(dto.getIdUser());
            NotificationEntity notificationPostEntity = notificationPostConvert.toEntity(dto);
            notificationPostEntity = notificationPostRepository.save(notificationPostEntity);

            NotificationDTO notificationPostDTO = notificationPostConvert.toDTO(notificationPostEntity);
            if (userEntity.getAvatar() != null) {
                notificationPostDTO.getUser().setAvatar(userEntity.getAvatar());
            }
            notificationPostDTO.getUser().setName(userEntity.getName());
            return notificationPostDTO;
        } else {
            return new NotificationDTO();
        }
    }

    public List<NotificationDTO> findAll () {
        List<NotificationEntity> notificationPostEntities = notificationPostRepository.findAll();
        List<NotificationDTO> notificationPostDTOS = new ArrayList<>();

        for (NotificationEntity entity : notificationPostEntities) {
            NotificationDTO notificationPostDTO = notificationPostConvert.toDTO(entity);

            UserEntity userEntity = userRepository.findOneById(entity.getIdUser());
            if (userEntity.getAvatar() != null) {
                notificationPostDTO.getUser().setAvatar(userEntity.getAvatar());
            }
            notificationPostDTO.getUser().setName(userEntity.getName());

            notificationPostDTOS.add(notificationPostDTO);
        }

        return notificationPostDTOS;
    }
}
