package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;

public class Apartamento extends Imovel {

    private int quartos;
    private boolean elevador;

    public Apartamento(String titulo, int quartos, boolean elevador) {
        this.titulo = titulo;
        this.tipo = "Apartamento";
        this.quartos = quartos;
        this.elevador = elevador;
    }

    @Override
    public boolean temFotos() {
        return false;
    }
}