package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.service.Singer.SingerService;
import com.hlt.hlt_entertainment.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/songs")
public class SongController {
@Autowired
    private SongService songService;
@Autowired
    private SingerService singerService;

@RequestMapping(value = "/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSong(@RequestBody Song song, UriComponentsBuilder ucBuilder){
    songService.save(song);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/songs/{id}").buildAndExpand(song.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}

}
