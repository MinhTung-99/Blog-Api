package com.example.blogapi.api;

import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.dto.SearchDTO;
import com.example.blogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostApi {

    @Autowired
    private PostService postService;

    @GetMapping("api/posts")
    public List<PostDTO> showPost () {
        return postService.findAll();
    }

    @GetMapping("api/podcast")
    public List<PostDTO> showPostCast () {
        return postService.podCastAll();
    }

    @GetMapping("api/courses/{idCourse}")
    public List<PostDTO> showPostCourse (@PathVariable("idCourse") long idCourse) {
        return postService.courseFindAll(idCourse);
    }

    @GetMapping("api/posts/search")
    public List<PostDTO> searchPost (@RequestBody SearchDTO searchDTO) {
        return postService.searchPost(searchDTO);
    }

    @GetMapping("api/podcast/search")
    public List<PostDTO> searchPostCast (@RequestBody SearchDTO searchDTO) {
        return postService.searchPostCast(searchDTO);
    }

    @PostMapping("api/posts")
    public PostDTO savePost (@RequestBody PostDTO model) {
        return postService.save(model);
    }

    @DeleteMapping("api/posts/{id}")
    public void deletePost (@PathVariable("id") long id) {
        postService.delete(id);
    }

    @PutMapping("api/posts/{id}")
    public PostDTO updatePost (@RequestBody PostDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return postService.update(model);
    }

    //==============GROUP==================
    @PostMapping("api/posts/course/{idCourse}")
    public PostDTO savePostCourse (@RequestBody PostDTO model, @PathVariable("idCourse") long idCourse) {
        return postService.save(model, idCourse);
    }
}
