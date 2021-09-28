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
        courseDTO.setIsJoin(courseEntity.getIsJoin());
        courseDTO.setId(courseEntity.getId());
        courseDTO.setTotalUser(courseEntity.getTotalUser());
        courseDTO.setDescription(courseEntity.getDescription());

        return courseDTO;
    }

    public CourseEntity toEntity (CourseDTO courseDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseDTO.getName());
        courseEntity.setImage(courseDTO.getImage());
        courseEntity.setTotalUser(courseDTO.getTotalUser());
        courseEntity.setIsJoin(false);
        courseEntity.setTotalUser(0L);
        courseEntity.setDescription(courseDTO.getDescription());

        return courseEntity;
    }
}
