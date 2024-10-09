package com.example.choice_platform_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Association {

    @EmbeddedId
    private AssociationId id;

    @ManyToOne
    @MapsId("uid")
    @JoinColumn(name = "uid")
    private User user;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    private Group group;

    // Embedded ID class for composite key
    @Embeddable
    public static class AssociationId implements Serializable {
        private Long uid;
        private Long groupId;

        // Getters, setters, equals, hashCode
    }
    // Getters, setters
}
