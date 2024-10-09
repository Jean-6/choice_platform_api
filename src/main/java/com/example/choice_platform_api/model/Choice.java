package com.example.choice_platform_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    // Relations
    @ManyToOne
    @JoinColumn(name = "pid")
    private Project project;

    @OneToMany(mappedBy = "choice")
    private List<Assignment> affectations;

    // Getters, setters
}
