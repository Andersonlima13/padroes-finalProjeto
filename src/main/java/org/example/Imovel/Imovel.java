package org.example.Imovel;
// factory - objeto abstrato

import org.example.Anuncio.Anunciavel;

public abstract class Imovel implements Anunciavel {

    protected String titulo;
    protected double preco;
    protected String tipo;

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
