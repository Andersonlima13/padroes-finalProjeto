package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class AnuncioEmRascunho implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        anuncio.setEstado(new AnuncioEmModeracao());
    }
}