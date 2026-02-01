package org.example.Anuncio.FiltroDeBusca;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.TipoNegociacao;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorTipo extends FiltroDecorator {

    private TipoNegociacao tipo;

    public FiltroPorTipo(FiltroBusca proximo, TipoNegociacao tipo) {
        super(proximo);
        this.tipo = tipo;
    }

    @Override
    public List<Anuncio> aplicar(List<Anuncio> anuncios) {
        return super.aplicar(anuncios)
                .stream()
                .filter(a -> a.getTipoNegociacao() == tipo)
                .collect(Collectors.toList());
    }
}
