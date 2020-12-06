package com.hlt.hlt_entertainment.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hlt.hlt_entertainment.model.Playlist;
import com.hlt.hlt_entertainment.model.Singer;

import com.hlt.hlt_entertainment.repo.SingerRepository;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.SongRepository;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/singers")
public class SingerController {
    final String CLOUDINARY_URL = "cloudinary://292468957674773:lcLLj26C4VX82SHtbJrjZkcwhas@dos9lacv4";
    @Autowired
    SingerRepository singerRepository;
    @Autowired
    SongRepository songRepository;
    @PostMapping("/uploadava")
    public ResponseEntity<Singer> uploadSongAva(@RequestParam("imgFile") MultipartFile multipartFile, Singer singer){

        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);

        try{
            File imgFile = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(imgFile);

            Map responseImg = cloudinary.uploader().upload(imgFile,  ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseImg);
            String urlImg = jsonObject.getString("url");

            singer.setLinkImg(urlImg);

        } catch ( IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
//        songService.save(newSong);

        return new ResponseEntity<>(singer, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Singer> createNewSinger(@Valid @RequestBody Singer singer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Long id : singer.getTuan()) {
            Song song = songRepository.findById(id).get();
            singer.songList.add(song);
        }

        singerRepository.save(singer);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Singer>> getAllSinger() {
        return new ResponseEntity<Iterable<Singer>>(singerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/newSinger")
    public ResponseEntity<Iterable<Singer>> getListNewSing(){
        List<Singer> list = singerRepository.findAll();
        int index = 1;
        List<Singer> listNewPlaylist = new ArrayList<>();
        for (int i = list.size(); i > 0 ; i--) {
            if(index<7){
                listNewPlaylist.add(list.get(i-1));
                index++;
            }
        }
        return new ResponseEntity<>(listNewPlaylist,HttpStatus.OK);
    }

}
