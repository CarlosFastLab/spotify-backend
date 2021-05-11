package com.example.spotifyback;

import org.springframework.data.jpa.repository.*;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}