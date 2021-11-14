package com.example.blogapi.api;

import com.example.blogapi.dto.UserLoveDTO;
import com.example.blogapi.service.UserLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoveApi {

    @Autowired
    private UserLoveService userLoveService;

    @CrossOrigin(origins = "*")
    @PostMapping("api/love")
    public UserLoveDTO saveUserLove (@RequestBody UserLoveDTO model) {
        return userLoveService.save(model);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("api/love/{idPost}")
    public Boolean deleteUserLove(@PathVariable("idPost") long id) {
        return userLoveService.delete(id);
    }
}
