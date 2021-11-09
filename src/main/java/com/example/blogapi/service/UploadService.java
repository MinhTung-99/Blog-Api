package com.example.blogapi.service;

import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.entity.CourseEntity;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.repository.CourseRepository;
import com.example.blogapi.repository.PostRepository;
import com.example.blogapi.repository.UserRepository;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UploadService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public String uploadImage (MultipartFile photo, Long idPost, Long idUser) {

        UserEntity userEntity = userRepository.findOneById(idUser);
        PostEntity postEntity = postRepository.findOneById(idPost);

        final String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        if (userEntity != null && userEntity.getTypeUser() != null) {
            if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                Path path = Paths.get("uploads/");
                try {
                    InputStream inputStream = photo.getInputStream();
                    Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    postEntity.setImage(baseUrl + "/image/" + photo.getOriginalFilename());
                    postRepository.save(postEntity);
                    return "Success";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Field";
    }

    public String uploadImageCourse (MultipartFile photo, Long idCourse, Long idUser) {

        UserEntity userEntity = userRepository.findOneById(idUser);
        CourseEntity courseEntity = courseRepository.findOneById(idCourse);

        final String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        if (userEntity != null && userEntity.getTypeUser() != null) {
            if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                Path path = Paths.get("uploads/");
                try {
                    InputStream inputStream = photo.getInputStream();
                    Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    courseEntity.setImage(baseUrl + "/image/" + photo.getOriginalFilename());
                    courseRepository.save(courseEntity);
                    return "Success";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Field";
    }

    public String uploadImageUser (MultipartFile photo, Long idUser) {

        UserEntity userEntity = userRepository.findOneById(idUser);

        final String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        if (userEntity != null && userEntity.getTypeUser() != null) {
            if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                Path path = Paths.get("uploads/");
                try {
                    InputStream inputStream = photo.getInputStream();
                    Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    userEntity.setAvatar(baseUrl + "/image/" + photo.getOriginalFilename());
                    userRepository.save(userEntity);
                    return "Success";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Field";
    }

    public String saveMP3(MultipartFile mp3, Long idPost, Long idUser) {
        UserEntity userEntity = userRepository.findOneById(idUser);
        PostEntity postEntity = postRepository.findOneById(idPost);

        final String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        if (userEntity != null && userEntity.getTypeUser() != null) {
            if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
                Path path = Paths.get("uploads/");

                try {
                    InputStream inputStream = mp3.getInputStream();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
                    String name = simpleDateFormat.format(new Date());

                    Files.copy(inputStream, path.resolve(mp3.getOriginalFilename()));
                    postEntity.setAudio(baseUrl + "/audio/" + mp3.getOriginalFilename());
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
