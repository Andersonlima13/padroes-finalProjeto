package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;

public class Apartamento extends Imovel {

    private int quartos;
    private boolean elevador;

    public Apartamento(String titulo, double preco, int quartos, boolean elevador) {
        this.titulo = titulo;
        this.preco = preco;
        this.tipo = "Apartamento";
        this.quartos = quartos;
        this.elevador = elevador;
    }
}