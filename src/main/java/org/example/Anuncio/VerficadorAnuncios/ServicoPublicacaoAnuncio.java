package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.VerficadorAnuncios.ModeradorAnuncio;

public class ServicoPublicacaoAnuncio {

    private ModeradorAnuncio cadeia;

    public ServicoPublicacaoAnuncio(ModeradorAnuncio cadeia) {
        this.cadeia = cadeia;
    }

    public void publicar(Anuncio anuncio) {
        System.out.println("🔎 Iniciando moderação...");
        cadeia.moderar(anuncio);

        anuncio.publicar();
        System.out.println("📢 Anúncio publicado com sucesso!");
    }
}
