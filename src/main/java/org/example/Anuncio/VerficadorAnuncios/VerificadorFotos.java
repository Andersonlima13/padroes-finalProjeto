package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;
import org.example.Config.ConfiguracaoSistema;

public class VerificadorFotos extends ModeradorBase {

    @Override
    public void moderar(Anuncio anuncio) {

        ConfiguracaoSistema config =
                ConfiguracaoSistema.getInstancia();

        if (!anuncio.temFotos()) {
            throw new RuntimeException("❌ Anúncio precisa de ao menos uma foto.");
        }



        passarParaProximo(anuncio);
    }
}