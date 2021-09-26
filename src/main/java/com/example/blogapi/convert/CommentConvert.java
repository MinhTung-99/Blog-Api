package com.example.blogapi.convert;

import com.example.blogapi.dto.CommentDTO;
import com.example.blogapi.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConvert {

    public CommentEntity toEntity (CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setIdPost(commentDTO.getIdPost());
        commentEntity.setIdUser(commentDTO.getIdUser());
        commentEntity.setDescription(commentDTO.getDescription());
        commentEntity.setIsLove(false);
        commentEntity.setTotalLove(0L);

        return commentEntity;
    }

    public CommentDTO toDTO (CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setIdPost(commentEntity.getIdPost());
        commentDTO.setIdUser(commentEntity.getIdUser());
        commentDTO.setDescription(commentEntity.getDescription());
        commentDTO.setId(commentEntity.getId());
        commentDTO.setIsLove(commentEntity.getIsLove());
        commentDTO.setTotalLove(commentEntity.getTotalLove());

        return commentDTO;
    }

    public CommentEntity toEntity (CommentDTO commentDTO, CommentEntity commentEntity) {
        CommentEntity entity = new CommentEntity();
        entity.setIdPost(commentEntity.getIdPost());
        entity.setIdUser(commentEntity.getIdUser());
        entity.setTotalLove(commentEntity.getTotalLove());
        entity.setIsLove(commentEntity.getIsLove());
        if (commentDTO.getDescription() != null) {
            entity.setDescription(commentDTO.getDescription());
        } else {
            entity.setDescription(commentEntity.getDescription());
        }

        return entity;
    }
}
