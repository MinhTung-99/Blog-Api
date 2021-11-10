package com.example.blogapi.convert;

import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.dto.UserDTO;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConvert {

    public PostEntity toEntity (PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        postEntity.setIdUser(postDTO.getIdUser());
        postEntity.setContent(postDTO.getContent());
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setImage(postDTO.getImage());
        postEntity.setCreatedDate(postDTO.getCreatedDate());
        postEntity.setModifileDate(postDTO.getModifileDate());
        postEntity.setNumView(0L);
        postEntity.setNumComment(0L);
        postEntity.setNumLove(0L);
        postEntity.setIsLove(false);
        postEntity.setRanker(postDTO.getRanker());

        return postEntity;
    }

    public PostDTO toDTO (PostEntity postEntity) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setIdUser(postEntity.getIdUser());
        postDTO.setContent(postEntity.getContent());
        postDTO.setTitle(postEntity.getTitle());
        postDTO.setImage(postEntity.getImage());
        postDTO.setCreatedDate(postEntity.getCreatedDate());
        postDTO.setModifileDate(postEntity.getModifileDate());
        postDTO.setNumView(postEntity.getNumView());
        postDTO.setNumComment(postEntity.getNumComment());
        postDTO.setNumLove(postEntity.getNumLove());
        postDTO.setIsLove(postEntity.getIsLove());
        postDTO.setAudio(postEntity.getAudio());
        postDTO.setIsGroup(postEntity.getIsGroup());
        postDTO.setIdGroup(postEntity.getIdGroup());
        postDTO.setRanker(postEntity.getRanker());

        return postDTO;
    }

    public PostDTO toDTO (PostEntity postEntity, UserEntity userEntity) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setIdUser(postEntity.getIdUser());
        postDTO.setContent(postEntity.getContent());
        postDTO.setTitle(postEntity.getTitle());
        postDTO.setImage(postEntity.getImage());
        postDTO.setCreatedDate(postEntity.getCreatedDate());
        postDTO.setModifileDate(postEntity.getModifileDate());
        postDTO.setNumView(postEntity.getNumView());
        postDTO.setNumComment(postEntity.getNumComment());
        postDTO.setNumLove(postEntity.getNumLove());
        postDTO.setIsLove(postEntity.getIsLove());
        postDTO.setAudio(postEntity.getAudio());
        postDTO.setRanker(postEntity.getRanker());

        postDTO.getUser().setName(userEntity.getName());
        return postDTO;
    }

    public PostEntity toEntity(PostDTO postDTO, PostEntity postEntity) {
        PostEntity entity = new PostEntity();
        entity.setIdUser(postEntity.getIdUser());
        if (postDTO.getTitle() != null) {
            entity.setTitle(postDTO.getTitle());
        } else {
            entity.setTitle(postEntity.getTitle());
        }
        if (postDTO.getContent() != null) {
            entity.setContent(postDTO.getContent());
        } else {
            entity.setContent(postEntity.getContent());
        }
        if (postDTO.getNumView() != null) {
            entity.setNumView(postDTO.getNumView());
        } else {
            entity.setNumView(postEntity.getNumView());
        }
        if (postDTO.getNumComment() != null) {
            entity.setNumComment(postDTO.getNumComment());
        } else {
            entity.setNumComment(postEntity.getNumComment());
        }
        /*if (postDTO.getNumLove() != null) {
            entity.setNumLove(postDTO.getNumLove());
        } else {
            entity.setNumLove(postEntity.getNumLove());
        }*/
        return entity;
    }
}
