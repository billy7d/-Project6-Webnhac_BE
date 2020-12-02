package com.hlt.hlt_entertainment.service.song;

import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.model.Song;
import com.hlt.hlt_entertainment.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Iterable<Song> findByCreator(AppUser creator) {
        return songRepository.findByCreator(creator);
    }

    @Override
    public Song save(Song song) {
        songRepository.save(song);
        return song;
    }

    @Override
    public Optional<Song> findById(Long id) {

        return songRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
