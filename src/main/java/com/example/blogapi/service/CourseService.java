package com.example.blogapi.service;

import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.convert.CourseConvert;
import com.example.blogapi.dto.CourseDTO;
import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.entity.CourseEntity;
import com.example.blogapi.entity.PostEntity;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.entity.UserLoveEntity;
import com.example.blogapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseConvert courseConvert;

    public CourseDTO save (CourseDTO dto) {
        CourseEntity courseEntity = courseConvert.toEntity(dto);
        courseEntity = courseRepository.save(courseEntity);

        return courseConvert.toDTO(courseEntity);
    }

    public CourseDTO update (CourseDTO dto) {
        CourseEntity courseEntity = courseConvert.toEntity(dto);
        courseEntity.setId(dto.getId());
        courseEntity = courseRepository.save(courseEntity);

        return courseConvert.toDTO(courseEntity);
    }

    public List<CourseDTO> findAll() {
        List<CourseDTO> results = new ArrayList<>();
        List<CourseEntity> entities = courseRepository.findAll();

        for(CourseEntity item : entities) {
            CourseDTO courseDTO = courseConvert.toDTO(item);
            results.add(courseDTO);
        }

        return results;
    }

    public void delete (long id) {
        courseRepository.deleteById(id);
    }
}
