package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;

public class PublicadoState implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        throw new IllegalStateException("❌ Anúncio já publicado");
    }

    @Override
    public void publicar(Anuncio anuncio) {
        throw new IllegalStateException("⚠️ Já está publicado");
    }

    @Override
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new RascunhoState());
    }

    // 💡 Comportamentos futuros
    public void aplicarFiltros() {
        System.out.println("🔎 Aplicando filtros...");
    }
}
