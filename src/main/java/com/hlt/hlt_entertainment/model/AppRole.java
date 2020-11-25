package com.hlt.hlt_entertainment.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

}
