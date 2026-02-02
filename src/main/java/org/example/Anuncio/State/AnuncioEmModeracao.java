package org.example.Anuncio.State;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.TipoNegociacao;
import org.example.Config.ConfiguracaoSistema;

public class AnuncioEmModeracao implements EstadoAnuncio {


    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        throw new IllegalStateException("Anuncio ja esta em moderacao");
    }

    @Override
    public void publicar(Anuncio anuncio) {

        ConfiguracaoSistema config =
                ConfiguracaoSistema.getInstancia();

        double preco = anuncio.getPreco();

        if (preco > config.getPrecoMax()) {
            anuncio.setEstado(new AnuncioSuspenso());
            throw new IllegalStateException("❌ Preço acima do permitido.");
        }

        if (anuncio.getTipoNegociacao() == TipoNegociacao.VENDA &&
                preco < config.getPrecoMinVenda()) {

            anuncio.setEstado(new AnuncioSuspenso());
            throw new IllegalStateException("❌ Preço abaixo do mínimo para venda.");
        }

        if (anuncio.getTipoNegociacao() == TipoNegociacao.ALUGUEL &&
                preco < config.getPrecoMinAluguel()) {

            anuncio.setEstado(new AnuncioSuspenso());
            throw new IllegalStateException("❌ Preço abaixo do mínimo para aluguel.");
        }

        anuncio.setEstado(new AnuncioAtivo());
    }

    @Override
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new AnuncioSuspenso());
    }
}