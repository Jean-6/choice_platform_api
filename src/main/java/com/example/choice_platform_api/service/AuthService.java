package com.example.choice_platform_api.service;
import com.example.choice_platform_api.dto.RegisterDto;
import com.example.choice_platform_api.entity.User;

public interface AuthService {
    User register(RegisterDto registerUserDto);
}
