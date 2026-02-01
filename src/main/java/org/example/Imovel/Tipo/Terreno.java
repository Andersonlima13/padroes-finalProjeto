package org.example.Imovel.Tipo;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
// objeto concreto de imovel

public class Terreno extends Imovel {

    private double area;

    public Terreno(String titulo, double area) {
        this.titulo = titulo;

        this.area = area;
    }




    @Override
    public boolean temFotos() {
        return false;
    }


}