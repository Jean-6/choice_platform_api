package com.example.choice_platform_api.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String title;
    private String description;
    private int sizeGroup;
    private String startDate;
    private String endDate;

    // Relations
    @OneToMany(mappedBy = "project")
    private List<Choice> choiceList;

    @OneToMany(mappedBy = "project")
    private List<Group> groups;

    // Getters, setters

}
