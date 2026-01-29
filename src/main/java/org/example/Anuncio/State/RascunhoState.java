package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class RascunhoState implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        anuncio.setEstado(new EmModeracaoState());
    }

    @Override
    public void publicar(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio em rascunho não pode ser publicado");
    }

    @Override
    public void suspender(Anuncio anuncio) {
        throw new IllegalStateException("❌ Rascunho não pode ser suspenso");
    }
}