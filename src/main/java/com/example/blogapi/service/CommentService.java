package com.example.blogapi.service;

import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.convert.CommentConvert;
import com.example.blogapi.dto.CommentDTO;
import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.entity.CommentEntity;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserLoveCommentEntity;
import com.example.blogapi.repository.CommentRepository;
import com.example.blogapi.repository.PostRepository;
import com.example.blogapi.repository.UserCommentLoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserCommentLoveRepository userCommentLoveRepository;

    @Autowired
    private CommentConvert commentConvert;

    public CommentDTO save (CommentDTO commentDTO) {
        CommentEntity commentEntity = commentConvert.toEntity(commentDTO);
        commentEntity = commentRepository.save(commentEntity);

        PostEntity postEntity = postRepository.findOneById(commentDTO.getIdPost());
        List<CommentEntity> commentEntities = commentRepository.findAll();

        Long numComment = 0L;
        for (CommentEntity entity: commentEntities) {
            if (postEntity.getId() == entity.getIdPost()) {
                numComment++;
            }
        }

        if (postEntity != null) {
            postEntity.setNumComment(numComment);
            postRepository.save(postEntity);
        }
        return commentConvert.toDTO(commentEntity);
    }

    public CommentDTO update (CommentDTO commentDTO) {
        CommentEntity oldCommentEntity = commentRepository.findOneById(commentDTO.getId());
        CommentEntity commentEntity = commentConvert.toEntity(commentDTO, oldCommentEntity);
        if (oldCommentEntity != null) {
            commentEntity.setId(oldCommentEntity.getId());
            commentEntity = commentRepository.save(commentEntity);

            return commentConvert.toDTO(commentEntity);
        }

        return new CommentDTO();
    }

    public void delete (Long idComment, Long idPost) {
        PostEntity postEntity = postRepository.findOneById(idPost);
        if (postEntity != null) {
            Long numComment = postEntity.getNumComment();
            numComment--;
            postEntity.setNumComment(numComment);
            postRepository.save(postEntity);
        }
        commentRepository.deleteById(idComment);
    }

    public List<CommentDTO> findAll(Long idPost) {
        List<CommentDTO> results = new ArrayList<>();
        List<CommentEntity> entities = commentRepository.findAll();
        List<UserLoveCommentEntity> userLoveCommentEntities = userCommentLoveRepository.findAll();

        for(CommentEntity item : entities) {
            if (item.getIdPost() == idPost) {
                CommentDTO commentDTO = commentConvert.toDTO(item);
                for (UserLoveCommentEntity entity: userLoveCommentEntities) {
                    if (entity.getIdComment() == item.getId() && entity.getIdUser() == UserUtil.ID_USER) {
                        commentDTO.setIsLove(true);
                    }
                }
                results.add(commentDTO);
            }
        }

        return results;
    }
}
