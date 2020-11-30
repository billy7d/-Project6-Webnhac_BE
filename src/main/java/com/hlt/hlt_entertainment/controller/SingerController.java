package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.repo.SingerRepository;
import com.hlt.hlt_entertainment.service.singer.SingerService;
import com.hlt.hlt_entertainment.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/singers")
@CrossOrigin("*")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Singer>> getAllSinger(){
        return new ResponseEntity<Iterable<Singer>>(singerService.findAll(), HttpStatus.OK);
    }
}
