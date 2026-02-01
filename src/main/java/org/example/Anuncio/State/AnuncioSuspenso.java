package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class AnuncioSuspenso implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio suspenso não pode ir para moderação.");
    }

    @Override
    public void publicar(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio suspenso não pode ser publicado.");
    }

    @Override
    public void suspender(Anuncio anuncio) {
        throw new IllegalStateException("⚠️ Anúncio já está suspenso.");
    }
}
