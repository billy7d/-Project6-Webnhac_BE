package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Playlist;
import com.hlt.hlt_entertainment.service.playlist.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
@CrossOrigin("*")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylists(){
        return new ResponseEntity<Iterable<Playlist>>(playlistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Long id){
        Playlist playlist = playlistService.findById(id).get();
        return new ResponseEntity<Playlist>(playlist,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Playlist> createCustomer(@RequestBody Playlist playlist) {
        playlistService.save(playlist);
        return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("id") Long id,Playlist playlist){
        Playlist currentPlaylist = playlistService.findById(id).get();
        currentPlaylist.setName(playlist.getName());
        currentPlaylist.setMusicType(playlist.getMusicType());
        currentPlaylist.setDescription(playlist.getDescription());

        return new ResponseEntity<Playlist>(currentPlaylist,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable("id") Long id){
        Playlist playlist = playlistService.findById(id).get();
        playlistService.deleteById(id);
        return new ResponseEntity<Playlist>(playlist,HttpStatus.OK);
    }
}
