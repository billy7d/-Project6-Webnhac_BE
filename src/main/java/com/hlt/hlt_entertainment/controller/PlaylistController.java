package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Playlist;
<<<<<<< HEAD
import com.hlt.hlt_entertainment.service.playlist.PlaylistService;
=======
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.PlaylistRepository;
import com.hlt.hlt_entertainment.repo.SongRepository;
>>>>>>> add-singer
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
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
=======
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
>>>>>>> add-singer
    }
}
