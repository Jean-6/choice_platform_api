package com.example.choice_platform_api.model;

import jakarta.persistence.*;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne//(cascade = CascadeType.ALL)
    private Project project;
}
