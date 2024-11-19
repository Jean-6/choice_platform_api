package com.example.choice_platform_api.service.impl;

import com.example.choice_platform_api.dto.RegisterDto;
import com.example.choice_platform_api.entity.User;
import com.example.choice_platform_api.repository.UserRepository;
import com.example.choice_platform_api.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;
    private final  PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User register(RegisterDto registerUserDto) {
        User user = new User();
        user.setEmail(registerUserDto.getEmail());
        user.setLogin(registerUserDto.getLogin());
        user.setMdp(passwordEncoder.encode(registerUserDto.getMdp()));
        return userRepository.save(user);
    }

}
