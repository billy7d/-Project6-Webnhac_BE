package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.SingerRepository;
import com.hlt.hlt_entertainment.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/singers")
public class SingerController {

    @Autowired
    SingerRepository singerRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/create")
    public ResponseEntity<Singer> createNewStudent(@Valid @RequestBody Singer singer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Long id: singer.getTuan()) {
            Song song  = songRepository.findById(id).get();
            singer.songList.add(song);
        }

        singerRepository.save(singer);
        return new ResponseEntity<>(singer,HttpStatus.OK);
    }


}
