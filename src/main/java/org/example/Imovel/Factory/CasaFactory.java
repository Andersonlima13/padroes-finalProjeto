package org.example.Imovel.Factory;

import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Imovel;
import org.example.Imovel.Tipo.Casa;
// fabricas concretas, ja criam com um padrao seguindo o rf02

public class CasaFactory implements Imovel {

    @Override
    public ImovelFactory criarImovel() {
        return new Casa(
                "Casa com Quintal",
                450_000,
                true
        );
    }
}