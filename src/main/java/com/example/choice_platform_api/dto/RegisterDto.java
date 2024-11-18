package com.example.choice_platform_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDto {
    @NotNull(message = "L'email est obligatoire")
    private String email;
    @NotNull(message = "Le nom utilisateur est obligatoire")
    private String login;
    @NotNull(message = "Le mot de passe est obligatoire")
    private String mdp;
}
