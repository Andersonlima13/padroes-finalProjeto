package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;

public class VerificadorPalavras extends ModeradorBase {

    @Override
    public void moderar(Anuncio anuncio) {
        if (anuncio.getTitulo().contains("palavrão")) {
            throw new RuntimeException("❌ Título contém termos proibidos.");
        }

        System.out.println("✔ Título aprovado.");
        passarParaProximo(anuncio);
    }
}