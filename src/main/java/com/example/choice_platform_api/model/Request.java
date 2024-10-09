package com.example.choice_platform_api.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Request {

    @EmbeddedId
    private RequestId id;

    @ManyToOne
    @MapsId("uid")
    @JoinColumn(name = "uid")
    private User user;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    private Group group;

    private String source;

    // Embedded ID class for composite key
    @Embeddable
    public static class RequestId implements Serializable {
        private Long uid;
        private Long groupId;

        // Getters, setters, equals, hashCode
    }

    // Getters, setters
}
