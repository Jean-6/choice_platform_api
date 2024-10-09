package com.example.choice_platform_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Group group;
    @OneToMany
    private List<User> userList;

}
