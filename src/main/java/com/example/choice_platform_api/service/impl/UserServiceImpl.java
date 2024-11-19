package com.example.choice_platform_api.service.impl;

import com.example.choice_platform_api.repository.UserRepository;
import com.example.choice_platform_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
    /*UserServiceImpl(UserRepository userRepository,
                    BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }*/

    @Override
    public boolean checkIfLoginExists(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }


}
