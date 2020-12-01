package com.hlt.hlt_entertainment.controller;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.SongRepository;

import com.hlt.hlt_entertainment.service.Singer.SingerService;
import com.hlt.hlt_entertainment.service.song.SongService;
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
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {


    final String CLOUDINARY_URL = "cloudinary://292468957674773:lcLLj26C4VX82SHtbJrjZkcwhas@dos9lacv4";

    @Autowired
    private SongService songService;

    @Autowired
    private SingerService singerService;
    @Autowired
    private SongRepository songRepository;


    @GetMapping("")
    public ResponseEntity<Iterable<Song>> getFile() {
        return new ResponseEntity<Iterable<Song>>(songService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/uploadmp3")

    public ResponseEntity<Song> uploadSong(@RequestParam("songFile") MultipartFile multipartFile, Song song){

        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);

        try {
            File mp3File = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(mp3File);

            Map responseMp3 = cloudinary.uploader().upload(mp3File, ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseMp3);
            String urlMp3 = jsonObject.getString("url");

            song.setLinkMp3(urlMp3);

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
//        songService.save(newSong);

        return new ResponseEntity<Song>(song, HttpStatus.OK);
    }

    @PostMapping("/uploadava")
    public ResponseEntity<Song> uploadSongAva(@RequestParam("imgFile") MultipartFile multipartFile, Song song){

        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);

        try{
            File imgFile = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(imgFile);

            Map responseImg = cloudinary.uploader().upload(imgFile,  ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseImg);
            String urlImg = jsonObject.getString("url");

            song.setLinkImg(urlImg);

        } catch ( IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
//        songService.save(newSong);

        return new ResponseEntity<Song>(song, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        for (Long id : song.getSingerValues()) {
            Singer singer = singerService.findSingerById(id).get();
            song.getSingerList().add(singer);
        }
        songService.save(song);
        return new ResponseEntity<Song>(song, HttpStatus.OK);
    }

    @GetMapping("/newSong")
    public ResponseEntity<Iterable<Song>> getListNewSong() {
        List<Song> list = songRepository.findAll();
        int index = 1;
        List<Song> listNewSong = new ArrayList<>();
        for (int i = list.size(); i > 0; i--) {
            if (index < 10) {
                listNewSong.add(list.get(i - 1));
                index++;
            }
        }
        return new ResponseEntity<>(listNewSong, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> getOneSong(@PathVariable Long id){
        Optional<Song> optionalStudent = songRepository.findById(id);
        if(optionalStudent.isPresent()) return new ResponseEntity<>(optionalStudent.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
