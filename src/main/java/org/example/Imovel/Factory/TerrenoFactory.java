package org.example.Imovel.Factory;

import org.example.Config.ConfiguracaoSistema;
import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Tipo.Terreno;

public class TerrenoFactory extends ImovelFactory {

    private final ConfiguracaoSistema config =
            ConfiguracaoSistema.getInstancia();

    // Factory Method → usa Singleton
    @Override
    public Imovel criarImovel() {
        return new Terreno(
                config.getTerrenoTituloPadrao(),
                config.getTerrenoAreaPadrao()
        );
    }

    // Sobrescrita manual
    public Imovel criarImovel(String titulo, int area) {
        return new Terreno(titulo, area);
    }
}