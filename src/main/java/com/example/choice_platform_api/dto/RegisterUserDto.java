package com.example.choice_platform_api.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String login;
    private String mdp;
}
