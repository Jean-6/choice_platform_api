package com.example.choice_platform_api.service;
import com.example.choice_platform_api.dto.LoginDto;
import com.example.choice_platform_api.dto.RegisterDto;
import com.example.choice_platform_api.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterDto registerDto);
    AuthResponse authenticate(LoginDto loginDto);
}
