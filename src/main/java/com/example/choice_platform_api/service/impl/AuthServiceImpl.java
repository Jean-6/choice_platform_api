package com.example.choice_platform_api.service.impl;

import com.example.choice_platform_api.dto.LoginDto;
import com.example.choice_platform_api.dto.RegisterDto;
import com.example.choice_platform_api.entity.User;
import com.example.choice_platform_api.repository.UserRepository;
import com.example.choice_platform_api.security.TokenType;
import com.example.choice_platform_api.service.AuthService;
import com.example.choice_platform_api.dto.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtServiceProvider jwtServiceProvider;

    @Override
    public AuthResponse register(RegisterDto registerDto) {
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(registerDto.getRole());
        user= userRepository.save(user);
        var jwt = jwtServiceProvider.generateToken(user);
        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        return AuthResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .token(jwt)
                .roles(roles)
                .tokenType(TokenType.BEARER.name())
                .build();
    }

    @Override
    public AuthResponse authenticate(LoginDto loginDto) {

        log.info(loginDto.getEmail());
        log.info(loginDto.getPassword());
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        var user= userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new IllegalArgumentException(""));
        var jwt = jwtServiceProvider.generateToken(user);
        return AuthResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .token(jwt)
                .tokenType(TokenType.BEARER.name())
                .build();
    }

}
