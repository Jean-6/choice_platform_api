package com.example.choice_platform_api.model;


import jakarta.persistence.*;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Group title;
    @OneToOne
    private Choice choice;
}
