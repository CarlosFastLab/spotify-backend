package com.example.spotifyback;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String senha;
    private Date dataNascimento;
    private String chamar;
    private int genero;

    public Usuario() {
        
    }

    public Usuario (String email, String senha, Date dataNascimento, String chamar, int genero) {
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.chamar = chamar;
        this.genero = genero;        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) { 
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) { 
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getChamar() {
        return chamar;
    }

    public void setChamar(String chamar) {
        this.chamar = chamar;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}