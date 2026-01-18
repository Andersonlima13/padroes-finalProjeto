package org.example.Imovel.Tipo;


import org.example.Imovel.Imovel;
// objeto concreto de imovel

public class Casa extends Imovel {

    private boolean possuiQuintal;

    public Casa(String titulo, double preco, boolean possuiQuintal) {
        this.titulo = titulo;
        this.preco = preco;
        this.possuiQuintal = possuiQuintal;
    }

    @Override
    protected void coletarCamposEspecificos() {
        System.out.println("🏠 Casa com quintal: " + possuiQuintal);
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
        return "Casa";
    }
}
