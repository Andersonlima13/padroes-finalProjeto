package org.example.Imovel.Factory;


import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Imovel;
import org.example.Imovel.Tipo.Terreno;
// fabricas concretas, ja criam com um padrao seguindo o rf02

public class TerrenoFactory implements Imovel {

    @Override
    public ImovelFactory criarImovel() {
        return new Terreno(
                "Terreno Residencial",
                200_000,
                300
        );
    }
}