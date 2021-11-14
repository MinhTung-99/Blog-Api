package com.example.blogapi.api;

import com.example.blogapi.dto.UserDTO;
import com.example.blogapi.dto.UserJoinCourseDTO;
import com.example.blogapi.service.UserJoinCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserJoinCourseApi {

    @Autowired
    private UserJoinCourseService userJoinCourseService;

    @CrossOrigin(origins = "*")
    @PostMapping("api/course/{idCourse}/user/{idUser}/join")
    public UserJoinCourseDTO saveCourse (@PathVariable("idCourse") long idCourse, @PathVariable("idUser") long idUser) {
        return userJoinCourseService.save(idUser, idCourse);
    }
}
