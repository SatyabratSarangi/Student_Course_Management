package com.satya.StudentCourseManagement.service;

import com.satya.StudentCourseManagement.dto.LoginRequest;
import com.satya.StudentCourseManagement.dto.LoginResponse;
import com.satya.StudentCourseManagement.model.Admin;
import com.satya.StudentCourseManagement.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AdminRepository adminRepository;

    public AuthService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public LoginResponse authenticate(LoginRequest loginRequest) {
        Optional<Admin> adminOptional = adminRepository.findByUsernameAndPassword(
                loginRequest.getUsername(), loginRequest.getPassword());

        if (adminOptional.isPresent()) {
            return new LoginResponse("Login successful", true);
        } else {
            return new LoginResponse("Invalid username or password", false);
        }
    }
}
