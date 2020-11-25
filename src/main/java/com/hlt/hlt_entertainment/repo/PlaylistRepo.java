package com.hlt.hlt_entertainment.repo;


import com.hlt.hlt_entertainment.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepo extends JpaRepository<Playlist,Long> {
}
