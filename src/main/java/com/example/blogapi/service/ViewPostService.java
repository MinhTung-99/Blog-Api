package com.example.blogapi.service;

import com.example.blogapi.convert.ViewPostConvert;
import com.example.blogapi.dto.ViewPostDTO;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.ViewPostEntity;
import com.example.blogapi.repository.PostRepository;
import com.example.blogapi.repository.ViewPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewPostService {

    @Autowired
    private ViewPostRepository viewPostRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ViewPostConvert viewPostConvert;

    public ViewPostDTO save (ViewPostDTO viewPostDTO) {
        ViewPostEntity entity = viewPostRepository.findOneByIdUser(viewPostDTO.getIdUser());
        if (entity == null) {
            PostEntity postEntity = postRepository.findOneById(viewPostDTO.getIdPost());
            ViewPostEntity viewPostEntity = viewPostConvert.toEntity(viewPostDTO);
            viewPostEntity = viewPostRepository.save(viewPostEntity);

            List<ViewPostEntity> viewPostEntities = viewPostRepository.findAll();
            List<PostEntity> postEntities = postRepository.findAll();

            Long numView = null;
            for (PostEntity post: postEntities) {
                numView = 0L;
                for (ViewPostEntity viewPost: viewPostEntities) {
                    if (post.getId() == viewPost.getIdPost()) {
                        numView++;
                    }
                }
            }

            if (postEntity != null) {
                postEntity.setNumView(numView);
                postRepository.save(postEntity);
            }

            return viewPostConvert.toDTO(viewPostEntity);
        } else {
            return new ViewPostDTO();
        }

    }
}
