package com.hlt.hlt_entertainment.service.singer;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.repo.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerRepository singerRepository;

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        singerRepository.save(singer);
        return singer;
    }

    @Override
    public Optional<Singer> findSingerById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        singerRepository.deleteById(id);
    }

}
