package com.example.spotifyback;

public class MusicaVO {
    public String artista;
    public String nomeMusica;
    public String album;
    public String musicaPath;

    public MusicaVO(){

    }

    public MusicaVO(Musica musica) {
        this.artista = musica.getArtista();
        this.nomeMusica = musica.getNomeMusica();
        this.album = musica.getAlbum();
        this.musicaPath = musica.getMusicaPath();
    }
}