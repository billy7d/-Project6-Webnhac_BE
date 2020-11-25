package com.hlt.hlt_entertainment.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter Song name, please!")
    private String name;

    private String description;

    @Transient
    @NotBlank(message = "Please attach file")
    private MultipartFile fileMp3;
    private String linkMp3;

    @Transient
    @NotBlank(message = "Please attach file.")
    private MultipartFile avatar;
    private String image;

    @NotBlank(message = "Please enter author name!")
    private String author;

    @ManyToMany
      @JoinTable(name = "singer_song",   joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "singer_id"))
    private List<Singer> singerName;

    private String creator;

    private String musicType;

    private String album;


}
