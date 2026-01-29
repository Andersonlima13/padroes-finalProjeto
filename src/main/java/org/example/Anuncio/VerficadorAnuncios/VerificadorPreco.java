package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;

public class VerificadorPreco extends ModeradorBase {

    @Override
    public void moderar(Anuncio anuncio) {
        if (anuncio.getPreco() <= 0) {
            throw new RuntimeException("❌ Preço inválido.");
        }

        System.out.println("✔ Preço válido.");
        passarParaProximo(anuncio);
    }
}