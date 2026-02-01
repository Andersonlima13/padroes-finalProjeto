package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPrecoMinimo extends FiltroDecorator {

    private double minimo;

    public FiltroPrecoMinimo(FiltroBusca proximo, double minimo) {
        super(proximo);
        this.minimo = minimo;
    }

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return super.aplicar(anuncios)
                .stream()
                .filter(a -> a.getPreco() >= minimo)
                .collect(Collectors.toList());
    }
}
