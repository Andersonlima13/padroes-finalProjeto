package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPrecoMaximo extends FiltroDecorator {

    private double maximo;

    public FiltroPrecoMaximo(FiltroBusca proximo, double maximo) {
        super(proximo);
        this.maximo = maximo;
    }

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return super.aplicar(anuncios)
                .stream()
                .filter(a -> a.getPreco() <= maximo)
                .collect(Collectors.toList());
    }
}
