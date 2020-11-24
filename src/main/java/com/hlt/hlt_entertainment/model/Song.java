package com.hlt.hlt_entertainment.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Transient
    private MultipartFile fileMp3;
    private String linkMp3;

    @Transient
    private MultipartFile avatar;
    private String image;

    private String author;

    @ManyToMany
      @JoinTable(name = "singer_song",   joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "singer_id"))
    private List<Singer> singerName;

    private String creator;

    private String musicType;

    private String album;


}
