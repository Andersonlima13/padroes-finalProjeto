package org.example.Imovel.Factory;


import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Tipo.Terreno;

public class TerrenoFactory implements ImovelFactory {

    @Override
    public Imovel criarImovel() {
        return new Terreno(
                "Terreno Residencial",
                200_000,
                300
        );
    }
}