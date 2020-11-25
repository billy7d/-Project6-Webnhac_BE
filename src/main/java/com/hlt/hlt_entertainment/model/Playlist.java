package com.hlt.hlt_entertainment.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String musicType;

    @NotEmpty
    private String description;

    @ManyToMany()
    @JoinTable(name = "playlist_song",joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songQuantity;

    private String dateCreated;


    @ManyToOne
    private AppUser creator;

    private Timestamp dateUpdated;

    private Long view;

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        String dateCreated1 = formatter.format(new Date());
        this.dateCreated = dateCreated1;
    }
}



