package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorPreco extends FiltroDecorator {

    private double max;

    public FiltroPorPreco(FiltroBusca proximo, double max) {
        super(proximo);
        this.max = max;
    }

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return super.aplicar(anuncios)
                .stream()
                .filter(a -> a.getItem().getPreco() <= max)
                .collect(Collectors.toList());
    }
}