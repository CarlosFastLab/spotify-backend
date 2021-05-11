package com.example.spotifyback;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;
    
    @GetMapping //Acesso via Get, poderia ser acesso via Post, Mapping, Delete... R
    public @ResponseBody Iterable<Playlist> AllPlaylists() {
        return playlistRepository.findAll();
    }

    @GetMapping ("/{id}") //D
    public Optional<Playlist> getPlaylistById(@PathVariable("id") Integer id) {
            return playlistRepository.findById(id);
    }

    //criar método com get por id

    @PostMapping //C
    public String addPlaylist(@RequestBody Playlist npl) {
        playlistRepository.save(npl);
        return "Saved";
    }

    @DeleteMapping ("/{id}") //D
    public ResponseEntity<HttpStatus> deletePlaylist(@PathVariable("id") Integer id) {
        try {
            playlistRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @PutMapping ("/{id}")//U
    public ResponseEntity<Playlist> atualizarPlaylist(@PathVariable("id") Integer id, @RequestBody Playlist playlistupdate) { //TEM QUE RECEBER REQUESTBODY para passar todo o valor do objeto alterado
        Optional<Playlist> playlistData = playlistRepository.findById(id);

        if (playlistData.isPresent()) {
            Playlist _playlist = playlistData.get();
            _playlist.setNome(playlistupdate.getNome());
            _playlist.setGenero(playlistupdate.getGenero());
            _playlist.setImagePath(playlistupdate.getImagePath());
            return new ResponseEntity<>(playlistRepository.save(_playlist), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/playlistAddMusica/{id}")
    public ResponseEntity<Playlist> addMusica(@PathVariable("id") Integer id, @RequestBody Musica musica) {
        Optional<Playlist> playlistData = playlistRepository.findById(id);

        if (playlistData.isPresent()) {
            Playlist _playlist = playlistData.get();
            _playlist.addMusica(musica);
            return new ResponseEntity<>(playlistRepository.save(_playlist), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}