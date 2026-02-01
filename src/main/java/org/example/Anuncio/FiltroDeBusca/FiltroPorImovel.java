package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorImovel extends FiltroDecorator {

    private String tipoImovel;

    public FiltroPorImovel(FiltroBusca proximo, String tipoImovel) {
        super(proximo);
        this.tipoImovel = tipoImovel;
    }

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return super.aplicar(anuncios)
                .stream()
                .filter(a -> a.getItem().getTipo().equalsIgnoreCase(tipoImovel))
                .collect(Collectors.toList());
    }
}
