package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Iterable<Song> findAllBySingerName(String nameSinger);
    Optional<Song> findById(Long id);
}
