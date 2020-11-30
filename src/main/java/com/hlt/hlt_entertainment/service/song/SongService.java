package com.hlt.hlt_entertainment.service.song;

import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SongService {
    Iterable<Song> findAll();

    Song save(Song song);

    Optional<Song> findById(Long id);

    void deleteById(Long id);
}
