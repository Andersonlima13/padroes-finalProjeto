package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;



public class ServicoPublicacaoAnuncio {

    private ModeradorAnuncio cadeia;

    public ServicoPublicacaoAnuncio(ModeradorAnuncio cadeia) {
        this.cadeia = cadeia;
    }

    public void publicar(Anuncio anuncio) {
        try {
            // 1️⃣ entra em moderação
            anuncio.enviarParaModeracao();

            // 2️⃣ passa pelo chain
            cadeia.moderar(anuncio);

            // 3️⃣ aprovado → ativo
            anuncio.publicar();

            System.out.println("📢 Anúncio publicado com sucesso!");
        } catch (RuntimeException e) {
            // ❌ falha → suspenso
            anuncio.suspender();
            System.out.println("❌ Moderação falhou: " + e.getMessage());
        }
    }
}