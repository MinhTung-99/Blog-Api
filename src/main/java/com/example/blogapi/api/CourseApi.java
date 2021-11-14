package com.example.blogapi.api;

import com.example.blogapi.convert.SearchCourseDTO;
import com.example.blogapi.dto.CourseDTO;
import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseApi {

    @Autowired
    private CourseService courseService;

    @CrossOrigin(origins = "*")
    @PostMapping("api/course")
    public CourseDTO saveCourse (@RequestBody CourseDTO model) {
        return courseService.save(model);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("api/course/{id}")
    public CourseDTO updateCourse (@RequestBody CourseDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return courseService.update(model);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/course")
    public List<CourseDTO> showCourse () {
        return courseService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/course/search")
    public List<CourseDTO> searchCourse (@RequestBody SearchCourseDTO dto) {
        return courseService.searchCourse(dto);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("api/course/{id}")
    public void deleteCourse (@PathVariable("id") long id) {
        courseService.delete(id);
    }
}
