package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;

public class Casa extends Imovel {

    private boolean possuiQuintal;

    public Casa(String titulo, double preco, boolean possuiQuintal) {
        this.titulo = titulo;
        this.preco = preco;
        this.tipo = "Casa";
        this.possuiQuintal = possuiQuintal;
    }

    @Override
    public boolean temFotos() {
        return true;
    }
}
