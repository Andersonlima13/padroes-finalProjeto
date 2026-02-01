package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class AnuncioEmRascunho implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        anuncio.setEstado(new AnuncioEmModeracao());
    }

    @Override
    public void publicar(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio em rascunho não pode ser publicado diretamente.");
    }

    @Override
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new AnuncioSuspenso());
    }
}