package org.example.Imovel.Factory;

import org.example.Config.ConfiguracaoSistema;
import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Tipo.Apartamento;

public class ApartamentoFactory extends ImovelFactory {

    private final ConfiguracaoSistema config =
            ConfiguracaoSistema.getInstancia();

    // Factory Method → usa Singleton
    @Override
    public Imovel criarImovel() {
        return new Apartamento(
                config.getApartamentoTituloPadrao(),
                config.getApartamentoQuartosPadrao(),
                config.isApartamentoPossuiElevadorPadrao()
        );
    }

    // Sobrescrita manual
    public Imovel criarImovel(
            String titulo,
            int quarto,
            boolean possuiElevador
    ) {
        return new Apartamento(
                titulo,
                quarto,
                possuiElevador
        );
    }
}
