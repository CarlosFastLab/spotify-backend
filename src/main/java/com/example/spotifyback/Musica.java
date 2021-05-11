package com.example.spotifyback;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String artista;
    private String nomeMusica;
    private String album;
    private String musicaPath;

    public Musica(){
        
    }

    public Musica (String artista, String nomeMusica, String album, String musicaPath) {
        this.artista = artista;
        this.nomeMusica = nomeMusica;
        this.album = album;
        this.musicaPath = musicaPath;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }
    
    public String getAlbum () {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getMusicaPath() {
        return musicaPath;
    }

    public void setMusicaPath(String musicaPath) {
        this.musicaPath = musicaPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}