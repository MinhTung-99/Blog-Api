package com.example.blogapi.api;

import com.example.blogapi.dto.CommentDTO;
import com.example.blogapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApi {

    @Autowired
    private CommentService commentService;

    @CrossOrigin(origins = "*")
    @GetMapping("api/comments/{idPost}")
    public List<CommentDTO> showComment (@PathVariable("idPost") long idPost) {
        return commentService.findAll(idPost);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/comments")
    public CommentDTO saveComment (@RequestBody CommentDTO model) {
        return commentService.save(model);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("api/comments/{idComment}")
    public CommentDTO updateComment (@RequestBody CommentDTO model, @PathVariable("idComment") long id) {
        model.setId(id);
        return commentService.update(model);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("api/posts/{idPost}/comments/{idComment}")
    public void deleteComment (@PathVariable("idPost") long idPost, @PathVariable("idComment") long idComment) {
        commentService.delete(idComment, idPost);
    }
}
