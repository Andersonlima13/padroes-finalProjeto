package org.example.Imovel.Factory;

import org.example.Config.ConfiguracaoSistema;
import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Imovel.Tipo.Casa;

public class CasaFactory extends ImovelFactory {

    private final ConfiguracaoSistema config =
            ConfiguracaoSistema.getInstancia();

    @Override
    public Imovel criarImovel() {
        return new Casa(
                config.getCasaTituloPadrao(),
                config.isCasaPossuiQuintalPadrao()
        );
    }

    // Sobrescrita manual → ignora config
    public Imovel criarImovel(String titulo, boolean possuiQuintal) {
        return new Casa(titulo, possuiQuintal);
    }
}