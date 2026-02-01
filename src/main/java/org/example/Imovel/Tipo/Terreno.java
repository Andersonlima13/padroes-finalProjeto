package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
// objeto concreto de imovel

public class Terreno extends Imovel {

    private double area;

    public Terreno(String titulo, double preco, double area) {
        this.titulo = titulo;
        this.preco = preco;
        this.area = area;
    }




    @Override
    public String getTitulo() {
        return "";
    }



    @Override
    public String getTipo() {
        return "Terreno";
    }

    @Override
    public boolean temFotos() {
        return false;
    }


}