package com.hlt.hlt_entertainment.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String musicType;

    private String description;

    @ManyToMany()
    @JoinTable(name = "playlist_song",joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songQuantity;

    private Timestamp dateCreated;

    @ManyToOne
    private AppUser creator;

    private Timestamp dateUpdated;

    private Long view;


    public Integer getSongQuantity() {
        List<Song> songQuantity = new ArrayList<>();
        return songQuantity.size();
    }

    public void setSongQuantity(List<Song> songQuantity) {
        this.songQuantity = songQuantity;
    }
}
