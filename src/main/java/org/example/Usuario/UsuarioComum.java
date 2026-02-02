package org.example.Usuario;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.ServicoBusca;

import java.util.List;

public abstract class UsuarioComum {

    protected ServicoBusca servicoBusca;
    private String nome;
    private String email;

    protected UsuarioComum(ServicoBusca servicoBusca, String nome, String email) {
        this.servicoBusca = servicoBusca;
        this.nome = nome;
        this.email = email;
    }

    public List<Anuncio> buscarAnuncios(List<Anuncio> anuncios) {
        return servicoBusca.buscar(anuncios);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}