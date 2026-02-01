package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;

import java.util.List;

public interface FiltroBusca {
    List<Anuncio> aplicar(List<Anuncio> anuncios);
}