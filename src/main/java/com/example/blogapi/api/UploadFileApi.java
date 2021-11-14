package com.example.blogapi.api;

import com.example.blogapi.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadFileApi {

    @Autowired
    private UploadService uploadService;

    @CrossOrigin(origins = "*")
    @PostMapping("api/upload/image/users/{idUser}/posts/{idPost}")
    public String saveImage(@RequestParam("image") MultipartFile photo, @PathVariable("idPost") long idPost, @PathVariable("idUser") long idUser) {
        return uploadService.uploadImage(photo, idPost, idUser);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/upload/image/users/{idUser}/course/{idCourse}")
    public String saveImageCourse(@RequestParam("image") MultipartFile photo, @PathVariable("idCourse") long idCourse, @PathVariable("idUser") long idUser) {
        return uploadService.uploadImageCourse(photo, idCourse, idUser);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("api/upload/image/users/{idUser}/avatar")
    public String saveImageUser(@RequestParam("image") MultipartFile photo, @PathVariable("idUser") long idUser) {
        return uploadService.uploadImageUser(photo, idUser);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "image/{photo:.+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        try {
            if (!photo.equals("")) {
                Path fileName = Paths.get("uploads", photo);
                byte[] buffer;
                buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/png"))
                        .body(byteArrayResource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

    //====================MP4=============================
    @CrossOrigin(origins = "*")
    @PostMapping("api/upload/mp3/users/{idUser}/posts/{idPost}")
    public String saveMp4(@RequestParam("mp3") MultipartFile mp3, @PathVariable("idPost") long idPost, @PathVariable("idUser") long idUser) {

        return uploadService.saveMP3(mp3, idPost, idUser);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "audio/{audio:.+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getMP4(@PathVariable("audio") String audio) {
        try {
            if (!audio.equals("")) {
                Path fileName = Paths.get("uploads", audio);
                byte[] buffer;
                buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                        .body(byteArrayResource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

}
