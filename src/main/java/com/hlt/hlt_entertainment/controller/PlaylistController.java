package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Playlist;
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.PlaylistRepository;
import com.hlt.hlt_entertainment.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private SongRepository songRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Playlist>> getAllSong(){
        return new ResponseEntity<>(playlistRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/newPlaylist")
    public ResponseEntity<Iterable<Playlist>> getListNewSong(){
        List<Playlist> list = playlistRepository.findAll();
        int leng = list.size()/2;
        int index = 1;
        List<Playlist> listNewPlaylist = new ArrayList<>();
        for (int i = list.size(); i > leng ; i--) {
            if(index<10){
                listNewPlaylist.add(list.get(i-1));
                index++;
            }
        }
        return new ResponseEntity<>(listNewPlaylist,HttpStatus.OK);
    }
}
