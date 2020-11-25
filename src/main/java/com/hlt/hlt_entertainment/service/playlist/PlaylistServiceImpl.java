package com.hlt.hlt_entertainment.service.playlist;

import com.hlt.hlt_entertainment.model.Playlist;
import com.hlt.hlt_entertainment.repo.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    PlaylistRepo playlistRepo;

    @Override
    public Iterable<Playlist> findAll() {
        return playlistRepo.findAll();
    }

    @Override
    public Playlist save(Playlist playlist) {
        playlistRepo.save(playlist);
        return playlist;
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        playlistRepo.deleteById(id);
    }
}
