package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import java.util.List;

public class BuscaBase implements FiltroBusca {

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return anuncios;
    }
}