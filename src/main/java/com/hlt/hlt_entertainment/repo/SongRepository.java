package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongRepository extends PagingAndSortingRepository<Song, Long> {
Page<Song> findByNameContains(String name, Pageable pageable);
Page<Song> findBySingerNameContains(Singer singer, Pageable pageable);
}
