package com.example.spotifyback;

import java.util.List;

import org.springframework.data.jpa.repository.*;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByEmail(String email);
}