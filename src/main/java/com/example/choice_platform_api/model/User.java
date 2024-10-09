package com.example.choice_platform_api.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private String login;
    private String mdp;
    private String role;

    // Relations
    @OneToMany(mappedBy = "user")
    private List<Association> associations;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    // Getters, setters
}
