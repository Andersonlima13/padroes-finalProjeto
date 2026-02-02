package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class AnuncioAtivo implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio ativo não pode voltar para moderação.");
    }

    @Override
    public void publicar(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio já está publicado.");
    }

    @Override
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new AnuncioSuspenso());
    }

    @Override
    public void vender(Anuncio anuncio) {
        anuncio.setEstado(new AnuncioVendido());
    }
}
