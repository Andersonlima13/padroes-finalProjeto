package org.example.Anuncio;

import org.example.Anuncio.State.AnuncioEmRascunho;
import org.example.Anuncio.State.EstadoAnuncio;

public class Anuncio {

    private Anuncio item;
    private EstadoAnuncio estado;
    private String titulo;

    public Anuncio(Anuncio item, String titulo ) {
        this.item = item;
        this.titulo = titulo;
        this.estado = new AnuncioEmRascunho();
    }

    // =========================
    // DADOS
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

    // =========================
    // STATE
    // =========================
    public void setEstado(EstadoAnuncio novoEstado) {
        this.estado = novoEstado;
        // notificarMudancaEstado();
        // registrarLog();
    }

    public void enviarParaModeracao() {
        estado.enviarParaModeracao(this);
    }

    public void publicar() {
        estado.publicar(this);
    }

    public void suspender() {
        estado.suspender(this);
    }

    public Anuncio getItem() {
        return  this.getItem();
    }

    public Object getEstado() {
        return this.estado;
    }
}