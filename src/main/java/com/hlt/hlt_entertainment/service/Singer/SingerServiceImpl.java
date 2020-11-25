package com.hlt.hlt_entertainment.service.Singer;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.repo.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SingerServiceImpl implements SingerService{

    @Autowired
    private SingerRepository singerRepository;
    @Override
    public Page<Singer> findAll(Pageable pageable) {
        return singerRepository.findAll(pageable);
    }

    @Override
    public Singer findBySingerId(Long id) {
        return singerRepository.findById(id).orElse(null);
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void delete(Long id) {
        singerRepository.deleteById(id);
    }
}
