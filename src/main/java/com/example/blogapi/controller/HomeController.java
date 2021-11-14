package com.example.blogapi.controller;


import com.example.blogapi.constant.UserUtil;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.model.JwtRequest;
import com.example.blogapi.model.JwtResponse;
import com.example.blogapi.repository.UserRepository;
import com.example.blogapi.service.UserService;
import com.example.blogapi.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) {

        List<UserEntity> userEntities = userRepository.findAll();
        for (UserEntity entity : userEntities) {
            if (jwtRequest.getUsername().equals(entity.getEmail()) && jwtRequest.getPassword().equals(entity.getPassword())) {
                try {
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    jwtRequest.getUsername(),
                                    jwtRequest.getPassword()
                            )
                    );
                } catch (BadCredentialsException e) {
                }

                final UserDetails userDetails
                        = userService.loadUserByUsername(jwtRequest.getUsername());

                final String token =
                        jwtUtility.generateToken(userDetails);

                UserUtil.ID_USER = entity.getId();

                return new JwtResponse(token, entity.getId(),
                        new SimpleDateFormat("dd/MM/yyyy").format(new Date()), new SimpleDateFormat("HH:mm").format(new Date())
                );
            }
        }

        return null;
    }
}
