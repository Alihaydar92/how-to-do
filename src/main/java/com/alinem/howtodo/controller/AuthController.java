package com.alinem.howtodo.controller;

import com.alinem.howtodo.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @PostMapping("/auth")
    ResponseEntity<?> handleAuthentication( UserInfoRepository user){
        return ResponseEntity.ok("Ok");

    }
}
