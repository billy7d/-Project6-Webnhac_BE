package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Playlist;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.service.playlist.PlaylistService;

import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.PlaylistRepository;
import com.hlt.hlt_entertainment.repo.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlists")
@CrossOrigin("*")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;
    @Autowired
    PlaylistRepository playlistRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylists() {
        return new ResponseEntity<Iterable<Playlist>>(playlistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Long id) {
        Playlist playlist = playlistService.findById(id).get();
        return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Playlist> createCustomer(@RequestBody Playlist playlist) {
        playlist.setDateCreated();
        playlistService.save(playlist);
        return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("id") Long id, @RequestBody Playlist playlist) {
        Playlist currentPlaylist = playlistService.findById(id).get();
        currentPlaylist.setName(playlist.getName());
        currentPlaylist.setCreator(playlist.getCreator());
        currentPlaylist.setDescription(playlist.getDescription());
        currentPlaylist.setDateCreated();
        currentPlaylist.setMusicType(playlist.getMusicType());
        currentPlaylist.setSongQuantity(playlist.getSongQuantity());

        playlistService.save(currentPlaylist);
        return new ResponseEntity<Playlist>(currentPlaylist, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable("id") Long id) {
        Playlist playlist = playlistService.findById(id).get();
        playlistService.deleteById(id);
        return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);

    }
    @GetMapping("/newPlaylist")
    public ResponseEntity<Iterable<Playlist>> getListNewSong(){
        List<Playlist> list = playlistRepository.findAll();
        int index = 1;
        List<Playlist> listNewPlaylist = new ArrayList<>();
        for (int i = list.size(); i > 0 ; i--) {
            if(index<10){
                listNewPlaylist.add(list.get(i-1));
                index++;
            }
        }
        return new ResponseEntity<>(listNewPlaylist,HttpStatus.OK);
    }


}