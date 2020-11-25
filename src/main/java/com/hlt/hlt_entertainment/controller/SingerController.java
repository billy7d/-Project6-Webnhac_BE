package com.hlt.hlt_entertainment.controller;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.service.Singer.SingerService;
import com.hlt.hlt_entertainment.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/singers/")
@CrossOrigin("*")
public class SingerController {
    @Autowired
    private SingerService singerService;
    @Autowired
    private SongService songService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
public ResponseEntity<Page<Singer>> showListSingers(Pageable pageable){
Page<Singer> singerPage = singerService.findAll(pageable);
if(singerPage == null){
return new ResponseEntity<Page<Singer>>(HttpStatus.NO_CONTENT);
}
return new ResponseEntity<Page<Singer>>(singerPage, HttpStatus.OK);
}
}
