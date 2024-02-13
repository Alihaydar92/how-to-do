package com.alinem.howtodo.controller;

import com.alinem.howtodo.entity.UserInfo;
import com.alinem.howtodo.repository.UserInfoRepository;
import com.alinem.howtodo.service.impl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserInfoService service;

    @PostMapping
    public String addUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

}
