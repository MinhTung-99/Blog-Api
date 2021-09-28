package com.example.blogapi.service;

import com.example.blogapi.convert.UserJoinCourseConvert;
import com.example.blogapi.dto.UserJoinCourseDTO;
import com.example.blogapi.entity.CourseEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.entity.UserJoinCourseEntity;
import com.example.blogapi.repository.CourseRepository;
import com.example.blogapi.repository.UserJoinCourseRepository;
import com.example.blogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJoinCourseService {

    @Autowired
    private UserJoinCourseRepository userJoinCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJoinCourseConvert userJoinCourseConvert;

    public UserJoinCourseDTO save(Long idUser, Long idCourse) {
        UserEntity userEntity = userRepository.findOneById(idUser);
        CourseEntity courseEntity = courseRepository.findOneById(idCourse);

        if (userEntity != null && courseEntity != null) {
            Long totalUser = courseEntity.getTotalUser();
            totalUser++;
            courseEntity.setTotalUser(totalUser);
            courseRepository.save(courseEntity);

            UserJoinCourseEntity userJoinCourseEntity = new UserJoinCourseEntity();
            userJoinCourseEntity.setIdUser(idUser);
            userJoinCourseEntity.setIdCourse(idCourse);
            userJoinCourseEntity = userJoinCourseRepository.save(userJoinCourseEntity);

            return userJoinCourseConvert.toDTO(userJoinCourseEntity);
        } else {
            return new UserJoinCourseDTO();
        }
    }

    public Boolean delete(Long idUser, Long idCourse) {
        List<UserJoinCourseEntity> userJoinCourseEntities = userJoinCourseRepository.findAll();
        for (UserJoinCourseEntity entity : userJoinCourseEntities) {
            if (entity.getIdUser() == idUser && entity.getIdCourse() == idCourse) {
                userJoinCourseRepository.deleteById(entity.getId());
                return true;
            }
        }

        return false;
    }
}
