package com.example.spotifyback;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping ("/usuarios")
    public @ResponseBody Iterable<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


    @GetMapping ("/usuario")
    public ResponseEntity<Usuario> getUsuarioByEmail(@RequestParam("email") String email) {
        System.out.println(email);
      List<Usuario> usuarioData = usuarioRepository.findByEmail(email);  
      if (!usuarioData.isEmpty()) {
        return new ResponseEntity<>(usuarioData.get(0), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping ("/usuarios")
    public @ResponseBody String addUsuario(@RequestBody Usuario nUsuario) {
        usuarioRepository.save(nUsuario);
        return "Saved";
    }

    @DeleteMapping ("/usuarios/{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping ("/usuarios/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuarioupdate) {
        Optional<Usuario> usuarioData = usuarioRepository.findById(id);

        if (usuarioData.isPresent()) {
            Usuario _usuario = usuarioData.get();
            _usuario.setEmail(usuarioupdate.getEmail());
            _usuario.setSenha(usuarioupdate.getSenha());
            _usuario.setDataNascimento(usuarioupdate.getDataNascimento());
            _usuario.setChamar(usuarioupdate.getChamar());
            _usuario.setGenero(usuarioupdate.getGenero());
            return new ResponseEntity<>(usuarioRepository.save(_usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}