package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class EmModeracaoState implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        throw new IllegalStateException("⚠️ Já está em moderação");
    }

    @Override
    public void publicar(Anuncio anuncio) {
        anuncio.setEstado(new PublicadoState());
    }

    @Override
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new RascunhoState());
    }
}
