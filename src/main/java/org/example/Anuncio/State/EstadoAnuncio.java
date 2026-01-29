package org.example.Anuncio.State;


import org.example.Anuncio.Anuncio;

public interface EstadoAnuncio {

    void enviarParaModeracao(Anuncio anuncio);
    void publicar(Anuncio anuncio);
    void suspender(Anuncio anuncio);
}
