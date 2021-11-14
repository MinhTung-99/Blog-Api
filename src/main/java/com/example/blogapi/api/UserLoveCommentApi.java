package com.example.blogapi.api;

import com.example.blogapi.dto.CommentDTO;
import com.example.blogapi.dto.UserLoveCommentDTO;
import com.example.blogapi.service.CommentService;
import com.example.blogapi.service.UserLoveCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoveCommentApi {

    @Autowired
    private UserLoveCommentService userLoveCommentService;

    @CrossOrigin(origins = "*")
    @PostMapping("api/posts/{idPost}/comments/{idComment}/userLove")
    public UserLoveCommentDTO saveUserLove (@RequestBody UserLoveCommentDTO model , @PathVariable("idPost") long idPost, @PathVariable("idComment") long idComment) {
        model.setIdPost(idPost);
        model.setIdComment(idComment);
        return userLoveCommentService.save(model);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("api/comment/{idComment}/userLove")
    public Boolean deleteUserLove (@PathVariable("idComment") long idComment) {
        return userLoveCommentService.delete(idComment);
    }
}
