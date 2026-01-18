package org.example.Imovel.Factory;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Tipo.Apartamento;

public class ApartamentoFactory implements ImovelFactory {
    @Override
    public Imovel criarImovel() {
        return new Apartamento(
                "Apartamento Central",
                350_000,
                5,
                true
        );
    }
}