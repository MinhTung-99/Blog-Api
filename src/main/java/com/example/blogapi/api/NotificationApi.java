package com.example.blogapi.api;

import com.example.blogapi.dto.NotificationDTO;
import com.example.blogapi.dto.PostDTO;
import com.example.blogapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationApi {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("api/notifications")
    public NotificationDTO savePost (@RequestBody NotificationDTO model) {
        return notificationService.save(model);
    }

    @GetMapping("api/notifications")
    public List<NotificationDTO> showPost () {
        return notificationService.findAll();
    }
}
