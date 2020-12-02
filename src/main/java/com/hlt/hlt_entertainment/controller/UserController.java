package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.service.playlist.PlaylistService;
import com.hlt.hlt_entertainment.service.song.SongService;
import com.hlt.hlt_entertainment.service.user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private SongService songService;

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/song/{id}")
    public ResponseEntity<Iterable<Song>> getAllSongOfUser(@PathVariable("id") Long id){
        AppUser creator = appUserService.findById(id);
        Iterable<Song> songIterable = songService.findByCreator(creator);
        return new  ResponseEntity<>(songIterable, HttpStatus.OK);
    }
}
