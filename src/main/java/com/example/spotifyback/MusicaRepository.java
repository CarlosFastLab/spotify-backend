package com.example.spotifyback;

import org.springframework.data.jpa.repository.*;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    
}