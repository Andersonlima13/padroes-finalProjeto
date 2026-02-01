package org.example.Imovel.Factory;

import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Imovel;
import org.example.Imovel.Tipo.Apartamento;

// fabricas concretas, ja criam com um padrao seguindo o rf02

public class ApartamentoFactory extends ImovelFactory {

    @Override
    public Imovel criarImovel() {
        return new Apartamento(
                "Apartamento Central",
                350_000,

                true
        );
    }
}