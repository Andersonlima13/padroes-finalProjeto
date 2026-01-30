package org.example.Imovel.Tipo;


import org.example.Imovel.ImovelFactory;
// objeto concreto de imovel

public class Casa extends ImovelFactory {

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
