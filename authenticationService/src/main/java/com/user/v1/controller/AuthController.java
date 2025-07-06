package com.user.v1.controller;

import com.user.v1.dto.request.LoginRequestDto;
import com.user.v1.dto.request.UserDto;
import com.user.v1.model.User;
import com.user.v1.service.AuthService;
import com.user.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
