package org.example.Anuncio.Notificacao;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.State.EstadoAnuncio;

public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Anuncio anuncio, EstadoAnuncio novoEstado) {
        System.out.println(
                "📧 Email para " +
                        anuncio.getAnunciante().getEmail() +
                        ": Seu anúncio '" +
                        anuncio.getTitulo() +
                        "' mudou para " +
                        novoEstado.getClass().getSimpleName()
        );
    }
}