package com.hlt.hlt_entertainment.service.playlist;

import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.model.Playlist;

import java.util.Optional;

public interface PlaylistService {
    Iterable<Playlist> findAll();

    Iterable<Playlist> findByCreator(AppUser creator);

    Playlist save(Playlist playlist);

    Optional<Playlist> findById(Long id);

    void deleteById(Long id);

}
