package com.example.choice_platform_api.service;


public interface UserService {

    boolean checkIfLoginExists(String login);
    boolean checkIfEmailExists(String email);
}
