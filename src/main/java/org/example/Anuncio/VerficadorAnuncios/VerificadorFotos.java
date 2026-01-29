package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;

public class VerificadorFotos extends ModeradorBase {

    @Override
    public void moderar(Anuncio anuncio) {
        if (!anuncio.temFotos()) {
            throw new RuntimeException("❌ Anúncio precisa de ao menos uma foto.");
        }

        System.out.println("✔ Fotos verificadas.");
        passarParaProximo(anuncio);
    }
}