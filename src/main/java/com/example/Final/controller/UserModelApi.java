package com.example.Final.controller;

import com.example.Final.entity.UserModel;
import com.example.Final.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserModelApi {

    private final MyUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserModel userModel) {
        userService.registr(userModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("Login successful");
    }
}
