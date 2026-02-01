package org.example.Anuncio;

import org.example.Anuncio.State.AnuncioEmRascunho;
import org.example.Anuncio.State.EstadoAnuncio;
import org.example.Usuario.Anunciante;

public class Anuncio {

    private Anunciavel item;          // imóvel, carro, etc
    private Anunciante anunciante;     // dono do anúncio
    private EstadoAnuncio estado;      // STATE
    private String titulo;
    private AnuncioPublisher publisher;

    public Anuncio(
            Anunciavel item,
            String titulo,
            Anunciante anunciante,
            AnuncioPublisher publisher
    ) {
        this.item = item;
        this.titulo = titulo;
        this.anunciante = anunciante;
        this.publisher = publisher;
        this.estado = new AnuncioEmRascunho();
    }

    // =========================
    // DADOS DO ANÚNCIO
    // =========================
    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return item.getPreco();
    }

    public boolean temFotos() {
        return item.temFotos();
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public Anunciavel getItem() {
        return item;
    }

    // =========================
    // STATE (Context)
    // =========================
    public EstadoAnuncio getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnuncio novoEstado) {
        this.estado = novoEstado;

        // 🔔 Observer notificado a cada mudança de estado
        publisher.notificarTodos(this, novoEstado);
    }

    // =========================
    // CICLO DE VIDA
    // =========================
    public void enviarParaModeracao() {
        estado.enviarParaModeracao(this);
    }

    public void publicar() {
        estado.publicar(this);
    }

    public void suspender() {
        estado.suspender(this);
    }
}
