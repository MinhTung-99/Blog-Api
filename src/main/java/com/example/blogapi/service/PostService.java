package com.example.blogapi.service;

import com.example.blogapi.constant.RankerUtil;
import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.convert.PostConvert;
import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.dto.SearchDTO;
import com.example.blogapi.entity.CommentEntity;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.entity.UserLoveEntity;
import com.example.blogapi.repository.CommentRepository;
import com.example.blogapi.repository.PostRepository;
import com.example.blogapi.repository.UserLoveRepository;
import com.example.blogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoveRepository userLoveRepository;

    @Autowired
    private PostConvert postConvert;

    public PostDTO save(PostDTO dto) {
        if (dto.getRanker() != null) {
            if (dto.getRanker().equals(RankerUtil.COPPER) || dto.getRanker().equals(RankerUtil.YELLOW)
                    || dto.getRanker().equals(RankerUtil.DIAMOND) || dto.getRanker().equals(RankerUtil.CHALLENGE)) {

                UserEntity userEntity = userRepository.findOneById(dto.getIdUser());
                if (userEntity != null && userEntity.getTypeUser() != null) {
                    if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                        PostEntity postEntity = postConvert.toEntity(dto);
                        postEntity = postRepository.save(postEntity);

                        return postConvert.toDTO(postEntity);
                    }
                }

                return new PostDTO();

            }
        }
        return new PostDTO();
    }

    public PostDTO update(PostDTO dto) {
        if (dto.getRanker() != null) {
            if (dto.getRanker().equals(RankerUtil.COPPER) || dto.getRanker().equals(RankerUtil.YELLOW)
                    || dto.getRanker().equals(RankerUtil.DIAMOND) || dto.getRanker().equals(RankerUtil.CHALLENGE)) {

                UserEntity userEntity = userRepository.findOneById(dto.getIdUser());
                PostEntity postEntitySearch = postRepository.findOneById(dto.getId());
                PostEntity oldEntity = postRepository.findOneById(dto.getId());
                if (postEntitySearch != null && userEntity != null && userEntity.getTypeUser() != null) {

                    if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                        PostEntity postEntity = postConvert.toEntity(dto, oldEntity);
                        postEntity.setId(dto.getId());

                        postEntity = postRepository.save(postEntity);

                        return postConvert.toDTO(postEntity);
                    }
                }

                return new PostDTO();

            }
        }

        return new PostDTO();
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostDTO> findAll() {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> entities = postRepository.findAll();
        List<UserLoveEntity> userLoveEntities = userLoveRepository.findAll();

        for (PostEntity item : entities) {
            if (item.getAudio() == null && item.getIsGroup() == null) {
                for (UserLoveEntity entity : userLoveEntities) {
                    if (entity.getIdPost() == item.getId() && entity.getIdUser() == UserUtil.ID_USER) {
                        item.setIsLove(true);
                    }
                }
                UserEntity userEntity = userRepository.findOneById(item.getIdUser());

                PostDTO postDTO = postConvert.toDTO(item, userEntity);
                results.add(postDTO);
            }
        }

        return results;
    }

    public List<PostDTO> findAllPostUnAuthentication() {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> entities = postRepository.findAll();

        for (PostEntity item : entities) {
            if (item.getRanker() != null) {
                if (item.getRanker().equals(RankerUtil.COPPER)) {
                    UserEntity userEntity = userRepository.findOneById(item.getIdUser());

                    PostDTO postDTO = postConvert.toDTO(item, userEntity);
                    results.add(postDTO);
                }
            }
        }

        return results;
    }

    public List<PostDTO> searchPost(SearchDTO searchDTO) {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> postEntities = postRepository.findAll();

        for (PostEntity entity : postEntities) {
            if (entity.getAudio() == null && entity.getIsGroup() == null) {
                if (entity.getTitle().toLowerCase().contains(searchDTO.getTitle().toLowerCase())) {
                    UserEntity userEntity = userRepository.findOneById(entity.getIdUser());

                    PostDTO postDTO = postConvert.toDTO(entity, userEntity);
                    results.add(postDTO);
                }
            }
        }

        return results;
    }

    public List<PostDTO> podCastAll() {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> entities = postRepository.findAll();
        List<UserLoveEntity> userLoveEntities = userLoveRepository.findAll();

        for (PostEntity item : entities) {
            if (item.getAudio() != null) {
                for (UserLoveEntity entity : userLoveEntities) {
                    if (entity.getIdPost() == item.getId() && entity.getIdUser() == UserUtil.ID_USER) {
                        item.setIsLove(true);
                    }
                }
                UserEntity userEntity = userRepository.findOneById(item.getIdUser());

                PostDTO postDTO = postConvert.toDTO(item, userEntity);
                results.add(postDTO);
            }
        }

        return results;
    }

    public List<PostDTO> podCastAllVisitor() {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> entities = postRepository.findAll();

        for (PostEntity item : entities) {
            if (item.getAudio() != null) {
                UserEntity userEntity = userRepository.findOneById(item.getIdUser());

                PostDTO postDTO = postConvert.toDTO(item, userEntity);
                results.add(postDTO);
            }
        }

        return results;
    }

    public List<PostDTO> courseFindAll(long idCourse) {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> entities = postRepository.findAll();
        List<UserLoveEntity> userLoveEntities = userLoveRepository.findAll();

        for (PostEntity item : entities) {
            if (item.getIsGroup() != null && item.getIdGroup() != null) {
                if (item.getIsGroup() && item.getIdGroup() == idCourse) {
                    for (UserLoveEntity entity : userLoveEntities) {
                        if (entity.getIdPost() == item.getId() && entity.getIdUser() == UserUtil.ID_USER) {
                            item.setIsLove(true);
                        }
                    }
                    UserEntity userEntity = userRepository.findOneById(item.getIdUser());

                    PostDTO postDTO = postConvert.toDTO(item, userEntity);
                    results.add(postDTO);
                }
            }
        }

        return results;
    }

    public List<PostDTO> searchPostCast(SearchDTO searchDTO) {
        List<PostDTO> results = new ArrayList<>();
        List<PostEntity> postEntities = postRepository.findAll();

        for (PostEntity entity : postEntities) {
            if (entity.getAudio() != null) {
                if (entity.getTitle().toLowerCase().contains(searchDTO.getTitle().toLowerCase())) {
                    UserEntity userEntity = userRepository.findOneById(entity.getIdUser());

                    PostDTO postDTO = postConvert.toDTO(entity, userEntity);
                    results.add(postDTO);
                }
            }
        }

        return results;
    }

    //==============GROUP=================
    public PostDTO save(PostDTO dto, Long idGroup) {
        if (dto.getRanker() != null) {
            if (dto.getRanker().equals(RankerUtil.COPPER) || dto.getRanker().equals(RankerUtil.YELLOW)
                    || dto.getRanker().equals(RankerUtil.DIAMOND) || dto.getRanker().equals(RankerUtil.CHALLENGE)) {

                UserEntity userEntity = userRepository.findOneById(dto.getIdUser());
                if (userEntity != null && userEntity.getTypeUser() != null) {
                    if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                        PostEntity postEntity = postConvert.toEntity(dto);
                        postEntity.setIsGroup(true);
                        postEntity.setIdGroup(idGroup);
                        postEntity = postRepository.save(postEntity);

                        return postConvert.toDTO(postEntity);
                    }
                }

                return new PostDTO();

            }
        }

        return new PostDTO();
    }
}
