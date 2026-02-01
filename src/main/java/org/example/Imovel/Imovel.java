package org.example.Imovel;

import org.example.Anuncio.Anunciavel;

public abstract class Imovel implements Anunciavel {

    protected String titulo;
    protected String tipo; // Casa, Apartamento etc.

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}