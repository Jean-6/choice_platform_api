package com.example.choice_platform_api.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Assignment {

    @EmbeddedId
    private AssignmentId id;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    private Group group;

    @ManyToOne
    @MapsId("cid")
    @JoinColumn(name = "cid")
    private Choice choice;

    // Embedded ID class for composite key
    @Embeddable
    public static class AssignmentId implements Serializable {
        private Long groupId;
        private Long cid;

        // Getters, setters, equals, hashCode
    }

    // Getters, setters
}
