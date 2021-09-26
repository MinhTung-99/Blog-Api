package com.example.blogapi.service;

import com.example.blogapi.convert.UserLoveCommentConvert;
import com.example.blogapi.dto.UserLoveCommentDTO;
import com.example.blogapi.entity.CommentEntity;
import com.example.blogapi.entity.UserLoveCommentEntity;
import com.example.blogapi.entity.UserLoveEntity;
import com.example.blogapi.repository.CommentRepository;
import com.example.blogapi.repository.UserCommentLoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoveCommentService {

    @Autowired
    private UserCommentLoveRepository userCommentLoveRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserLoveCommentConvert userLoveCommentConvert;


    public UserLoveCommentDTO save (UserLoveCommentDTO userLoveCommentDTO) {
        UserLoveCommentEntity userLoveCommentEntity = userLoveCommentConvert.toEntity(userLoveCommentDTO);
        userLoveCommentEntity = userCommentLoveRepository.save(userLoveCommentEntity);

        CommentEntity commentEntity = commentRepository.findOneById(userLoveCommentDTO.getIdComment());
        List<UserLoveCommentEntity> userLoveCommentEntities = userCommentLoveRepository.findAll();
        Long totalLove = 0L;
        for (UserLoveCommentEntity entity : userLoveCommentEntities) {
            if (entity.getIdComment() == commentEntity.getId()) {
                totalLove++;
            }
        }
        if (commentEntity != null) {
            commentEntity.setTotalLove(totalLove);
            commentRepository.save(commentEntity);
        }

        return userLoveCommentConvert.toDTO(userLoveCommentEntity);
    }

    public Boolean delete (Long idComment) {

        CommentEntity commentEntity = commentRepository.findOneById(idComment);
        if (commentEntity != null) {
            commentEntity.setIsLove(false);
            commentRepository.save(commentEntity);
        }
        List<UserLoveCommentEntity> userLoveEntities = userCommentLoveRepository.findAll();
        for (UserLoveCommentEntity item: userLoveEntities) {
            if (item.getIdPost() == idComment) {
                userCommentLoveRepository.deleteById(item.getId());
                return true;
            }
        }
        return false;
    }
}
