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

    @CrossOrigin(origins = "*")
    @GetMapping("api/user")
    public List<UserDTO> showUser () {
        return userService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/user/search")
    public List<UserDTO> searchUser (@RequestBody SearchDTO dto) {
        return userService.searchUser(dto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/user/search/ranker")
    public List<UserDTO> searchUserByRanker (@RequestBody SearchDTO dto) {
        return userService.searchUserByRanker(dto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/user/search/{id}")
    public UserDTO searchOneUser (@PathVariable("id") long id) {
        return userService.findOneUserById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/register")
    public UserDTO saveUser (@RequestBody UserDTO model) {
        return userService.save(model);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("api/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("api/user/{id}")
    public UserDTO updateUser (@RequestBody UserDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return userService.update(model);
    }
}
