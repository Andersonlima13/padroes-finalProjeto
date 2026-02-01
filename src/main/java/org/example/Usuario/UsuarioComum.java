package org.example.Usuario;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.ServicoBusca;

import java.util.List;

public abstract class UsuarioComum {

    protected ServicoBusca servicoBusca;

    protected UsuarioComum(ServicoBusca servicoBusca) {
        this.servicoBusca = servicoBusca;
    }

    public List<Anuncio> buscarAnuncios(List<Anuncio> anuncios) {
        return servicoBusca.buscar(anuncios);
    }
}
