package com.satya.StudentCourseManagement.controller;

import com.satya.StudentCourseManagement.dto.LoginRequest;
import com.satya.StudentCourseManagement.dto.LoginResponse;
import com.satya.StudentCourseManagement.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.authenticate(loginRequest);
        if (!response.isSuccess()) {
            throw new RuntimeException(response.getMessage());
        }
        return response;

    }
}
