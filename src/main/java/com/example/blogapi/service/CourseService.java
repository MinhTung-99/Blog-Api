package com.example.blogapi.service;

import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.convert.CourseConvert;
import com.example.blogapi.convert.SearchCourseDTO;
import com.example.blogapi.dto.CourseDTO;
import com.example.blogapi.entity.CourseEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.entity.UserJoinCourseEntity;
import com.example.blogapi.repository.CourseRepository;
import com.example.blogapi.repository.UserJoinCourseRepository;
import com.example.blogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserJoinCourseRepository userJoinCourseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseConvert courseConvert;

    public CourseDTO save(CourseDTO dto) {
        UserEntity userEntity = userRepository.findOneById(UserUtil.ID_USER);
        if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
            CourseEntity courseEntity = courseConvert.toEntity(dto);
            courseEntity = courseRepository.save(courseEntity);

            return courseConvert.toDTO(courseEntity);
        }

        return new CourseDTO();
    }

    public CourseDTO update(CourseDTO dto) {
        UserEntity userEntity = userRepository.findOneById(UserUtil.ID_USER);
        if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
            CourseEntity courseEntity = courseConvert.toEntity(dto);
            courseEntity.setId(dto.getId());
            courseEntity = courseRepository.save(courseEntity);

            return courseConvert.toDTO(courseEntity);
        }

        return new CourseDTO();
    }

    public List<CourseDTO> findAll() {
        List<CourseDTO> results = new ArrayList<>();
        List<CourseEntity> entities = courseRepository.findAll();
        List<UserJoinCourseEntity> userEntities = userJoinCourseRepository.findAll();

        for (CourseEntity item : entities) {
            for (UserJoinCourseEntity userJoinCourseEntity : userEntities) {
                if (item.getId() == userJoinCourseEntity.getIdCourse() && userJoinCourseEntity.getIdUser() == UserUtil.ID_USER) {
                    item.setIsJoin(true);
                }
            }
            CourseDTO courseDTO = courseConvert.toDTO(item);
            results.add(courseDTO);
        }

        return results;
    }

    public List<CourseDTO> searchCourse(SearchCourseDTO dto) {
        List<CourseDTO> results = new ArrayList<>();
        List<CourseEntity> entities = courseRepository.findAll();
        List<UserJoinCourseEntity> userEntities = userJoinCourseRepository.findAll();

        for (CourseEntity item : entities) {
            if (dto.getName().contains(item.getName())) {
                for (UserJoinCourseEntity userJoinCourseEntity : userEntities) {
                    if (item.getId() == userJoinCourseEntity.getIdCourse() && userJoinCourseEntity.getIdUser() == UserUtil.ID_USER) {
                        item.setIsJoin(true);
                    }
                }
                CourseDTO courseDTO = courseConvert.toDTO(item);
                results.add(courseDTO);
            }
        }

        return results;
    }

    public void delete(long id) {
        UserEntity userEntity = userRepository.findOneById(UserUtil.ID_USER);
        if (userEntity.getTypeUser().equals(UserUtil.TYPE_USER)) {
            courseRepository.deleteById(id);
        }
    }
}
