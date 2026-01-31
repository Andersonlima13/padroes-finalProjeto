package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;


import org.example.Pagamento.Plano;

public class ServicoPublicacaoAnuncio {

    private ModeradorAnuncio cadeia;

    public ServicoPublicacaoAnuncio(ModeradorAnuncio cadeia) {
        this.cadeia = cadeia;
    }

    public void publicar(Anuncio anuncio, Plano plano) {

        if (!plano.isAtivo()) {
            throw new IllegalStateException("Plano inativo. Não é possível publicar anúncio.");
        }

        System.out.println("🔎 Iniciando moderação...");
        cadeia.moderar(anuncio);

        anuncio.publicar();
        System.out.println("📢 Anúncio publicado com sucesso!");
    }
}

