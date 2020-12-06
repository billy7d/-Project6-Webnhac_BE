package com.hlt.hlt_entertainment.repo;


import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
Iterable<Playlist> findAllByCreator(AppUser creator);
}
