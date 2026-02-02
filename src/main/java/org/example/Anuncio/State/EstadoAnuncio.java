package org.example.Anuncio.State;


import org.example.Anuncio.Anuncio;



public interface EstadoAnuncio {

    // transição padrão
    void enviarParaModeracao(Anuncio anuncio);

    // transições opcionais
    default void publicar(Anuncio anuncio) {
        throw new IllegalStateException("Transição não permitida neste estado.");
    }

    default void suspender(Anuncio anuncio) {
        throw new IllegalStateException("Transição não permitida neste estado.");
    }

    default void vender(Anuncio anuncio) {
        throw new IllegalStateException("Transição não permitida neste estado.");
    }
}
