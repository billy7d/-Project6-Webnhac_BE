package com.hlt.hlt_entertainment.repo;

<<<<<<< HEAD
import com.hlt.hlt_entertainment.model.Singer;
import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

=======
import com.hlt.hlt_entertainment.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Iterable<Song> findAllBySingerName(String nameSinger);
    Optional<Song> findById(Long id);
>>>>>>> add-singer
}
