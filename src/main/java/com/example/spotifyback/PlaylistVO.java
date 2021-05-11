package com.example.spotifyback;

import java.util.List;

public class PlaylistVO {
    public String nome;
    public String genero;
    public String imagePath;
    public List<MusicaVO> musicas;

    public PlaylistVO(){

    }

    public PlaylistVO(Playlist playlist){
        this.nome = playlist.getNome();
        this.genero = playlist.getGenero();
        this.imagePath = playlist.getImagePath();
        // this.musicas = playlist.getMusicas();
    }
}