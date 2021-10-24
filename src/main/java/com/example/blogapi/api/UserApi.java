package com.example.blogapi.api;

import com.example.blogapi.dto.SearchDTO;
import com.example.blogapi.dto.UserDTO;
import com.example.blogapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("api/user")
    public List<UserDTO> showUser () {
        return userService.findAll();
    }

    @GetMapping("api/user/search")
    public List<UserDTO> searchUser (@RequestBody SearchDTO dto) {
        return userService.searchUser(dto);
    }

    @GetMapping("api/user/search/ranker")
    public List<UserDTO> searchUserByRanker (@RequestBody SearchDTO dto) {
        return userService.searchUserByRanker(dto);
    }

    @GetMapping("api/user/search/{id}")
    public UserDTO searchOneUser (@PathVariable("id") long id) {
        return userService.findOneUserById(id);
    }

    @PostMapping("api/register")
    public UserDTO saveUser (@RequestBody UserDTO model) {
        return userService.save(model);
    }

    @DeleteMapping("api/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @PutMapping("api/user/{id}")
    public UserDTO updateUser (@RequestBody UserDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return userService.update(model);
    }
}
