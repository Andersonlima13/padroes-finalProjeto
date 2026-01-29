package org.example;

import org.example.Anuncio.Anuncio;
import org.example.Anuncio.VerficadorAnuncios.ModeradorAnuncio;
import org.example.Anuncio.VerficadorAnuncios.VerificadorFotos;
import org.example.Anuncio.VerficadorAnuncios.VerificadorPalavras;
import org.example.Anuncio.VerficadorAnuncios.VerificadorPreco;
import org.example.Imovel.Factory.ApartamentoFactory;
import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Anuncio.VerficadorAnuncios.ServicoPublicacaoAnuncio;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        // ==============================
        // RF01 – criação do imóvel
        // ==============================
        ImovelFactory factory = new ApartamentoFactory();
        Imovel apartamento = factory.criarImovel();

        // ==============================
        // Criação do anúncio
        // ==============================
        Anuncio anuncio = new Anuncio(
                apartamento,
                "Apartamento em condomínio fechado",
                "Apartamento bem localizado, com 2 quartos e ótima iluminação.",
                250000
        );

        // ==============================
        // RF03 – cadeia de moderação
        // ==============================
        ModeradorAnuncio palavras = new VerificadorFotos();
        ModeradorAnuncio preco = new VerificadorPreco();
        ModeradorAnuncio descricao = new VerificadorPalavras();

        palavras
                .setProximo(preco)
                .setProximo(descricao);

        // ==============================
        // Serviço de publicação
        // ==============================
        ServicoPublicacaoAnuncio servico =
                new ServicoPublicacaoAnuncio(palavras);

        // ==============================
        // Publicação do anúncio
        // ==============================
        servico.publicar(anuncio);

        System.out.println("Status final do anúncio: " + anuncio.getStatus());
    }
}