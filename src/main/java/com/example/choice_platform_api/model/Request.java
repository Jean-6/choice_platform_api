package com.example.choice_platform_api.model;


import jakarta.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Group group;
    @OneToOne
    private User user;
    private String source;
}
