package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class AnuncioVendido implements EstadoAnuncio {
    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        throw new IllegalStateException("Anuncio ja foi vendido");
    }
    // estado terminal
}