package com.alimama.mealgpt.controller;

import com.alimama.mealgpt.pojo.LoginRequest;
import com.alimama.mealgpt.pojo.LoginResponse;
import com.alimama.mealgpt.pojo.ResponseEntity;
import com.alimama.mealgpt.result.ApiResult;
import com.alimama.mealgpt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        // whether the user found or not

        LoginResponse loginResponse = userService.login(loginRequest);

        HttpStatus code = (loginResponse == null) ? HttpStatus.UNAUTHORIZED : HttpStatus.ACCEPTED;

        return new ResponseEntity(code, loginResponse);
    }

    @GetMapping("/test")
    public String sayHello() {
        return "Hello World";
    }



}









