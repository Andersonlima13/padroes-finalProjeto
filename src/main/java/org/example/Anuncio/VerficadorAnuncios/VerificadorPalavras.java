package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;
import org.example.Config.ConfiguracaoSistema;

import java.util.List;

public class VerificadorPalavras extends ModeradorBase {

    @Override
    public void moderar(Anuncio anuncio) {

        ConfiguracaoSistema config =
                ConfiguracaoSistema.getInstancia();

        List<String> termosProibidos =
                config.getTermosProibidos();

        String titulo = anuncio.getTitulo().toLowerCase();

        for (String termo : termosProibidos) {
            if (titulo.contains(termo.toLowerCase())) {
                throw new RuntimeException(
                        "❌ Título contém termo proibido: " + termo
                );
            }
        }

        System.out.println("✔ Título aprovado.");
        passarParaProximo(anuncio);
    }
}