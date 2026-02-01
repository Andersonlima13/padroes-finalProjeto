package org.example.Anuncio.Notificacao;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.State.EstadoAnuncio;

public class NotificadorWhatsApp implements Notificador {

    @Override
    public void notificar(Anuncio anuncio, EstadoAnuncio novoEstado) {
        System.out.println(
                "📱 WhatsApp: Seu anúncio '" +
                        anuncio.getTitulo() +
                        "' agora está em " +
                        novoEstado.getClass().getSimpleName()
        );
    }
}