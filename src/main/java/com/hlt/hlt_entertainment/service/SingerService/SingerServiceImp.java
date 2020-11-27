package com.hlt.hlt_entertainment.service.SingerService;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.repo.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SingerServiceImp implements SingerService{
    @Autowired
    private SingerRepository singerRepository;
    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Singer findById(Long id) {
        return null;
    }

    @Override
    public void save(Singer model) {

    }

    @Override
    public void remove(Long id) {

    }
}
