package com.hlt.hlt_entertainment.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String musicType;

    private String description;

    private Long songQuantity;

    private Timestamp dateCreated;

    @ManyToOne
    private AppUser creator;

    private Timestamp dateUpdated;

    private Long view;
}
