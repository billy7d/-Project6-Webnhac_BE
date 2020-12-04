package com.hlt.hlt_entertainment.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hlt.hlt_entertainment.model.Playlist;

import com.hlt.hlt_entertainment.service.playlist.PlaylistService;

import com.hlt.hlt_entertainment.repo.PlaylistRepository;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/playlists")
@CrossOrigin("*")
public class PlaylistController {
    final String CLOUDINARY_URL = "cloudinary://292468957674773:lcLLj26C4VX82SHtbJrjZkcwhas@dos9lacv4";
    @Autowired
    PlaylistService playlistService;
    @Autowired
    PlaylistRepository playlistRepository;
    @PostMapping("/uploadava")
    public ResponseEntity<Playlist> uploadSongAva(@RequestParam("imgFile") MultipartFile multipartFile, Playlist playlist){

        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);

        try{
            File imgFile = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(imgFile);

            Map responseImg = cloudinary.uploader().upload(imgFile,  ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseImg);
            String urlImg = jsonObject.getString("url");

            playlist.setLinkImg(urlImg);

        } catch ( IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
//        songService.save(newSong);

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
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