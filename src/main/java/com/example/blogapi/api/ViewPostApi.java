package com.example.blogapi.api;

import com.example.blogapi.dto.UserLoveDTO;
import com.example.blogapi.dto.ViewPostDTO;
import com.example.blogapi.service.ViewPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewPostApi {

    @Autowired
    private ViewPostService viewPostService;

    @CrossOrigin(origins = "*")
    @PostMapping("api/view")
    public ViewPostDTO saveUserLove (@RequestBody ViewPostDTO model) {
        return viewPostService.save(model);
    }
}
