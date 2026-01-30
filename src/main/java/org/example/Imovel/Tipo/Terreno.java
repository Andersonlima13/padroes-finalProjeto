package org.example.Imovel.Tipo;

import org.example.Imovel.ImovelFactory;
// objeto concreto de imovel

public class Terreno extends ImovelFactory {

    private double area;

    public Terreno(String titulo, double preco, double area) {
        this.titulo = titulo;
        this.preco = preco;
        this.area = area;
    }

    @Override
    protected void coletarCamposEspecificos() {
        System.out.println("🌱 Terreno com área de " + area + " m²");
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
        return "Terreno";
    }
}