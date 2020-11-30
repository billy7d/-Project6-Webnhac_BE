package com.hlt.hlt_entertainment.service.playlist;

import com.hlt.hlt_entertainment.model.Playlist;
import com.hlt.hlt_entertainment.repo.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public Iterable<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist save(Playlist playlist) {
        playlistRepository.save(playlist);
        return playlist;
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        playlistRepository.deleteById(id);
    }
}
