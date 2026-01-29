package org.example.Anuncio;

import org.example.Anuncio.State.EstadoAnuncio;
import org.example.Anuncio.State.RascunhoState;
import org.example.Imovel.Imovel;


// anuncio é a entidade que serve para rf01 e rf02



public class Anuncio {

    private Imovel imovel;
    private String titulo;
    private EstadoAnuncio estado;

    public Anuncio(Imovel imovel, String titulo) {
        this.imovel = imovel;
        this.titulo = titulo;
        this.estado = new RascunhoState(); // estado inicial
    }

    // === STATE ===
    public void setEstado(EstadoAnuncio novoEstado) {
        this.estado = novoEstado;
       // notificarMudancaEstado();
       //  registrarLog();
    }

    public EstadoAnuncio getEstado() {
        return estado;
    }

    // === Ações delegadas ===
    public void enviarParaModeracao() {
        estado.enviarParaModeracao(this);
    }

    public void publicar() {
        estado.publicar(this);
    }

    public void suspender() {
        estado.suspender(this);
    }

    public EstadoAnuncio getStatus() {
        return estado;
    }
}