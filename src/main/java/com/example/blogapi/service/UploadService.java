package com.example.blogapi.service;

import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.repository.PostRepository;
import com.example.blogapi.repository.UserRepository;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public String uploadImage (MultipartFile photo, Long idPost, Long idUser) {

        UserEntity userEntity = userRepository.findOneById(idUser);
        PostEntity postEntity = postRepository.findOneById(idPost);

        if (userEntity != null && userEntity.getTypeUser() != null) {
            if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                Path path = Paths.get("uploads/");
                try {
                    InputStream inputStream = photo.getInputStream();
                    Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    postEntity.setImage("http://localhost:8080/image/" + photo.getOriginalFilename());
                    postRepository.save(postEntity);
                    return "Success";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Field";
    }

    public String saveMP4 (MultipartFile mp3, Long idPost, Long idUser) {
        UserEntity userEntity = userRepository.findOneById(idUser);
        PostEntity postEntity = postRepository.findOneById(idPost);

        if (userEntity != null && userEntity.getTypeUser() != null) {
            if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                Path path = Paths.get("uploads/");

                try {
                    InputStream inputStream = mp3.getInputStream();
                    Files.copy(inputStream, path.resolve(mp3.getOriginalFilename()));
                    postEntity.setAudio("http://localhost:8080/audio/" + mp3.getOriginalFilename());
                    postRepository.save(postEntity);
                    return "Success";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Field";
    }
}
