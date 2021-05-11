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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping  //R
    public @ResponseBody Iterable<Musica> getAllMusicas() {
        return musicaRepository.findAll();
    }

    @PostMapping //C
    public String addMusica(@RequestBody Musica nMusica){
        musicaRepository.save(nMusica);
        return "Saved";
        }

    @DeleteMapping ("/{id}") //D
    public ResponseEntity<HttpStatus> deleteMusica(@PathVariable ("id") Integer id) {
        try {
            musicaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping ("/{id}") //U
    public ResponseEntity<Musica> atualizarMusica(@PathVariable("id") Integer id, @RequestBody Musica musicaupdate) {
        Optional<Musica> musicaData = musicaRepository.findById(id);

        if(musicaData.isPresent()) {
            Musica _musica = musicaData.get();
            _musica.setArtista(musicaupdate.getArtista());
            _musica.setNomeMusica(musicaupdate.getNomeMusica());
            _musica.setAlbum(musicaupdate.getAlbum());
            _musica.setMusicaPath(musicaupdate.getMusicaPath());
            return new ResponseEntity<>(musicaRepository.save(_musica), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 
    }
}