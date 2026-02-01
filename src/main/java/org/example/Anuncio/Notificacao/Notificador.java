package org.example.Anuncio.Notificacao;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.State.EstadoAnuncio;

public interface Notificador {

    void notificar(Anuncio anuncio, EstadoAnuncio novoEstado);

}   