package com.example.spotifyback;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String genero;
    private String imagePath;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "playlist_musicas", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "musicas_id", referencedColumnName = "id"))
    private List<Musica> musicas;

    public Playlist() {

    }

    public Playlist (final String nome, final String genero, final String imagePath){
        this.nome = nome;
        this.genero = genero;
        this.imagePath = imagePath;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath (final String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void addMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}

