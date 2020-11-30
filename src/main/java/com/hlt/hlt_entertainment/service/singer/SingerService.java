package com.hlt.hlt_entertainment.service.Singer;

import com.hlt.hlt_entertainment.model.Singer;

import java.util.Optional;

public interface   SingerService {
    Iterable<Singer> findAll();

    Singer save(Singer singer);

    Optional<Singer> findSingerById(Long id);

    void deleteById(Long id);
}
