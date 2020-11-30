package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findById(Long id);
}
