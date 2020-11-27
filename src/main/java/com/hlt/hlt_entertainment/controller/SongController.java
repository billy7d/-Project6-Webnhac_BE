package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongRepository songRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Song>> getAllSong(){
        return new ResponseEntity<>(songRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> getOneStudent(@PathVariable Long id){
        Optional<Song> optionalStudent = songRepository.findById(id);
        if(optionalStudent.isPresent()) return new ResponseEntity<>(optionalStudent.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/newSong")
    public ResponseEntity<Iterable<Song>> getListNewSong(){
        List<Song> list = songRepository.findAll();
        int leng = list.size()/2;
        int index = 1;
        List<Song> listNewSong = new ArrayList<>();
        for (int i = list.size(); i > leng ; i--) {
            if(index<10){
                listNewSong.add(list.get(i-1));
                index++;
            }
        }
        return new ResponseEntity<>(listNewSong,HttpStatus.OK);
    }
}
