package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;

public class Apartamento extends Imovel {

    private int andar;
    private boolean possuiElevador;

    public Apartamento(String titulo, double preco, int andar, boolean possuiElevador) {
        this.titulo = titulo;
        this.preco = preco;
        this.andar = andar;
        this.possuiElevador = possuiElevador;
    }

    @Override
    protected void coletarCamposEspecificos() {
        System.out.println("🏢 Apartamento no andar " + andar +
                " | Elevador: " + possuiElevador);
    }

    @Override
    public String getTitulo() {
        return "";
    }

    @Override
    public double getPreco() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Apartamento";
    }
}
