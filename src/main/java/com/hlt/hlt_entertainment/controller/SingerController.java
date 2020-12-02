package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Singer;

import com.hlt.hlt_entertainment.repo.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.SongRepository;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/singers")
public class SingerController {

    @Autowired
    SingerRepository singerRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/create")
    public ResponseEntity<Singer> createNewSinger(@Valid @RequestBody Singer singer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Long id : singer.getTuan()) {
            Song song = songRepository.findById(id).get();
            singer.songList.add(song);
        }

        singerRepository.save(singer);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Singer>> getAllSinger() {
        return new ResponseEntity<Iterable<Singer>>(singerRepository.findAll(), HttpStatus.OK);
    }



}
