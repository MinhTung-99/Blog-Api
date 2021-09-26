package com.example.blogapi.service;

import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.convert.UserLoveConvert;
import com.example.blogapi.dto.UserLoveDTO;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.entity.UserLoveEntity;
import com.example.blogapi.repository.PostRepository;
import com.example.blogapi.repository.UserLoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoveService {

    @Autowired
    private UserLoveRepository userLoveRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserLoveConvert userLoveConvert;

    public UserLoveDTO save (UserLoveDTO userLoveDTO) {
        UserLoveEntity userLoveEntity = userLoveConvert.toEntity(userLoveDTO);
        userLoveRepository.save(userLoveEntity);

        List<UserLoveEntity> userLoveEntities = userLoveRepository.findAll();

        PostEntity postEntity = postRepository.findOneById(userLoveDTO.getIdPost());
        Long numLove = 0L;
        for (UserLoveEntity entity : userLoveEntities) {
            if (entity.getIdPost() == postEntity.getId()) {
                numLove++;
            }
        }
        if (postEntity != null) {
            postEntity.setNumLove(numLove);
        }
        postRepository.save(postEntity);

        return userLoveConvert.toDTO(userLoveEntity);
    }

    public Boolean delete (Long idPost) {
        PostEntity postEntity = postRepository.findOneById(idPost);
        Long numLove = postEntity.getNumLove();
        numLove--;
        postEntity.setNumLove(numLove);
        postEntity.setIsLove(false);
        postRepository.save(postEntity);

        List<UserLoveEntity> userLoveEntities = userLoveRepository.findAll();
        for (UserLoveEntity item: userLoveEntities) {
            if (item.getIdPost() == idPost && item.getIdUser() == UserUtil.ID_USER) {
                userLoveRepository.deleteById(item.getId());
                return true;
            }
        }

        return false;
    }


}
