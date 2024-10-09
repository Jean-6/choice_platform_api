package com.example.choice_platform_api.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relations
    @ManyToOne
    @JoinColumn(name = "pid")
    private Project project;

    @OneToMany(mappedBy = "group")
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "group")
    private List<Request> requests;

    @OneToMany(mappedBy = "group")
    private List<Association> associations;

    // Getters, setters

}
