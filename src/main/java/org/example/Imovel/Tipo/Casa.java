package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;

public class Casa extends Imovel {

    private boolean possuiQuintal;

    public Casa(String titulo,  boolean possuiQuintal) {
        this.titulo = titulo;

        this.tipo = "Casa";
        this.possuiQuintal = possuiQuintal;
    }

    @Override
    public boolean temFotos() {
        return true;
    }
}
