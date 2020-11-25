package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.service.Singer.SingerService;
import com.hlt.hlt_entertainment.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/song")
public class SongController {
@Autowired
    private SongService songService;
@Autowired
    private SingerService singerService;

@RequestMapping(value = "/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSong(@RequestBody Singer singer){

    return null;
}

}
