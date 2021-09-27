package com.example.blogapi.convert;

import com.example.blogapi.dto.CourseDTO;
import com.example.blogapi.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseConvert {

    public CourseDTO toDTO (CourseEntity courseEntity) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(courseEntity.getName());
        courseDTO.setTotalUser(courseEntity.getTotalUser());
        courseDTO.setImage(courseEntity.getImage());
        courseDTO.setId(courseEntity.getId());
        courseDTO.setCreatedDate(courseEntity.getCreatedDate());
        courseDTO.setModifileDate(courseEntity.getModifileDate());

        return courseDTO;
    }

    public CourseEntity toEntity (CourseDTO courseDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseDTO.getName());
        courseEntity.setImage(courseDTO.getImage());
        courseEntity.setTotalUser(courseDTO.getTotalUser());

        return courseEntity;
    }
}
