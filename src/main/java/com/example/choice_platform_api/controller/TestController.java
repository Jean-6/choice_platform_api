package com.example.choice_platform_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/user")
    public String helloUser(){
       return "Hello user";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello admin";
    }

}
