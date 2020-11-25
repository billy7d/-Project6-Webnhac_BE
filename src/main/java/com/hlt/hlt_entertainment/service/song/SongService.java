package com.hlt.hlt_entertainment.service.song;

import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {
    Page<Song> findAll(Pageable pageable);

    Song findBySongId(Long id);

    Song Save(Song song);

    void delete(Long id);
}
