package org.example.Anuncio;

import org.example.Anuncio.FiltroDeBusca.FiltroBusca;
import org.example.Anuncio.State.AnuncioAtivo;

import java.util.List;
import java.util.stream.Collectors;

public class ServicoBusca {

    private FiltroBusca filtro;

    public ServicoBusca(FiltroBusca filtro) {
        this.filtro = filtro;
    }

    public List<Anuncio> buscar(List<Anuncio> anuncios) {

        // só anúncios ATIVOS podem ser buscados
        List<Anuncio> ativos = anuncios.stream()
                .filter(a -> a.getEstado() instanceof AnuncioAtivo)
                .collect(Collectors.toList());

        return filtro.aplicar(ativos);
    }
}