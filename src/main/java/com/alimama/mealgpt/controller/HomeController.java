package com.alimama.mealgpt.controller;

import com.alimama.mealgpt.pojo.*;
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

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);

        HttpStatus code = (registerRequest == null) ? HttpStatus.UNAUTHORIZED : HttpStatus.ACCEPTED;

        return new ResponseEntity(code, registerResponse);
    }

    @GetMapping("/test")
    public String sayHello() {
        return "Hello World";
    }



}









