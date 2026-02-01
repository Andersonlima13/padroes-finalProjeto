package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import java.util.List;

public abstract class FiltroDecorator implements FiltroBusca {

    protected FiltroBusca proximo;

    protected FiltroDecorator(FiltroBusca proximo) {
        this.proximo = proximo;
    }

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return proximo.aplicar(anuncios);
    }
}