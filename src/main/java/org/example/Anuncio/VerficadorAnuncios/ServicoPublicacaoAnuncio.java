package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;


import org.example.Pagamento.Plano;

public class ServicoPublicacaoAnuncio {

    private ModeradorAnuncio cadeia;

    public ServicoPublicacaoAnuncio(ModeradorAnuncio cadeia) {
        this.cadeia = cadeia;
    }

    public void publicar(Anuncio anuncio) {
        try {
            anuncio.enviarParaModeracao(); // muda para EM_MODERACAO
            cadeia.moderar(anuncio);
            anuncio.publicar();            // muda para ATIVO
            System.out.println("📢 Anúncio publicado com sucesso!");
        } catch (RuntimeException exception) {
            anuncio.suspender();           // volta para RASCUNHO
            System.out.println("❌ Moderação falhou: " + exception.getMessage());
        }
    }
}