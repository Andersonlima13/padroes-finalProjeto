package org.example.Anuncio;

import org.example.Anuncio.State.EstadoAnuncio;
import org.example.Anuncio.State.RascunhoState;

public class Anuncio {

    private Anunciavel item;        // imóvel, carro, etc
    private EstadoAnuncio estado;    // STATE
    private String titulo;

    public Anuncio(Anunciavel item, String titulo) {
        this.item = item;
        this.titulo = titulo;
        this.estado = new RascunhoState(); // estado inicial
    }

    // =========================
    // DADOS DO ANÚNCIO
    // =========================
    public Anunciavel getItem() {
        return item;
    }

    public String getTitulo() {
        return titulo;
    }

    // =========================
    // STATE (Context)
    // =========================
    public void setEstado(EstadoAnuncio novoEstado) {
        this.estado = novoEstado;
        // notificarMudancaEstado();
        // registrarLog();
    }

    public EstadoAnuncio getEstado() {
        return estado;
    }

    // =========================
    // AÇÕES DE CICLO DE VIDA
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
