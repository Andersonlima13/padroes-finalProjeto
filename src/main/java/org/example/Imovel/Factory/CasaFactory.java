package org.example.Imovel.Factory;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Tipo.Casa;

public class CasaFactory extends ImovelFactory {

    @Override
    public Imovel criarImovel() {
        return new Casa(
                "Casa com Quintal",
                450_000,
                true
        );
    }
}
