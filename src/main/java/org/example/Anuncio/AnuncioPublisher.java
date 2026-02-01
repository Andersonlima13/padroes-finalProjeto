package org.example.Anuncio;

import org.example.Anuncio.Notificacao.Notificador;
import org.example.Anuncio.State.EstadoAnuncio;
import java.util.ArrayList;
import java.util.List;

public class AnuncioPublisher {

    private final List<Notificador> notificadores = new ArrayList<>();

    public void adicionar(Notificador notificador) {
        notificadores.add(notificador);
    }

    public void remover(Notificador notificador) {
        notificadores.remove(notificador);
    }

    public void notificarTodos(Anuncio anuncio, EstadoAnuncio novoEstado) {
        for (Notificador notificador : notificadores) {
            notificador.notificar(anuncio, novoEstado);
        }
    }
}