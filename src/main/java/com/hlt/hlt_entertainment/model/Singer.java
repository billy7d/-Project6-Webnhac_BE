package com.hlt.hlt_entertainment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Singer {
    public  Singer(){
        songList  = new ArrayList<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String Name;

    @NotNull
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    private Date birthday;

    @NotNull
    private String musicType;

    @NotNull
    private String story;

    @NotNull
    private String band;


    @ManyToMany(mappedBy = "singerName")
    public List<Song> songList;

    private Long view;

    @Transient
    @ElementCollection
    private List<Long> tuan;

    private String valuesSong;
}
