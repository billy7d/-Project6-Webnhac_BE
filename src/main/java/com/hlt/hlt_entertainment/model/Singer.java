package com.hlt.hlt_entertainment.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;

    private String gender;

    private Date birthday;

    private String musicType;

    private String story;

    private String band;


    @ManyToMany(mappedBy = "singerName")
    private List<Song> songList;

    private Long view;
}
