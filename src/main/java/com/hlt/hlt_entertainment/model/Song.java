package com.hlt.hlt_entertainment.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotEmpty
    @Size(min = 3)
    private String description;

    @Transient
    private MultipartFile fileMp3;

    private String linkMp3;
    


    @Transient
    private MultipartFile fileAvatar;

    private String linkImg;
    


    @NotBlank(message = "Please enter author name!")
    private String author;

    @NotBlank
    private String creator;

    @NotBlank
    private String musicType;

    @NotBlank
    private String album;

    @ManyToMany
      @JoinTable(name = "singer_song",   joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "singer_id"))
    private List<Singer> singerList;

    @Transient
    @ElementCollection
    private List<Long> singerValues;

    public Song(){
        singerList = new ArrayList<>();
    }

}
