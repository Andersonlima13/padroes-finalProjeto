package org.example;

import org.example.Anuncio.FiltroDeBusca.*;
import org.example.Usuario.*;
import org.example.Pagamento.*;
import org.example.Anuncio.*;
import org.example.Anuncio.VerficadorAnuncios.*;
import org.example.Anuncio.Notificacao.*;
import org.example.Imovel.Tipo.*;
import org.example.Anuncio.State.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== SIMULAÇÃO REAL DO SISTEMA =====\n");

        // =====================================================
        // 1️⃣ ANUNCIANTES
        // =====================================================
        Anunciante proprietario = new Proprietario(
                "João da Silva",
                "joao@email.com",
                "1199999-9999",
                "123.456.789-00"
        );

        Anunciante corretor = new Corretor(
                "Imobiliária Central",
                "contato@imobcentral.com",
                "113333-4444",
                "12.345.678/0001-99"
        );


        // =====================================================
        // 2️⃣ PLANOS + PAGAMENTO
        // =====================================================
        Plano planoBasico = new PlanoBasico();
        GatewayPagamento gateway = new CartaoAdapter();
        ServicoAssinatura servicoAssinatura = new ServicoAssinatura(gateway);

        System.out.println("🔐 Proprietário contratando plano...");
        servicoAssinatura.contratarPlano(planoBasico);
        System.out.println();

        // =====================================================
        // 3️⃣ OBSERVER (notificações)
        // =====================================================
        AnuncioPublisher publisher = new AnuncioPublisher();
        publisher.adicionar(new NotificadorWhatsApp());

        // =====================================================
        // 4️⃣ IMÓVEIS (produtos físicos)
        // =====================================================
        Casa casaComFotos = new Casa("Casa com quintal", true) {
            @Override
            public boolean temFotos() {
                return true;
            }
        };

        Casa casaSemFotos = new Casa("Casa sem fotos", false) {
            @Override
            public boolean temFotos() {
                return false;
            }
        };

        Apartamento apartamentoComFotos = new Apartamento(
                "Apartamento central",
                3,
                true
        ) {
            @Override
            public boolean temFotos() {
                return true;
            }
        };

        // =====================================================
        // 5️⃣ ANÚNCIOS (preço e tipo no ANÚNCIO)
        // =====================================================
        Anuncio anuncioVendaValido = new Anuncio(
                casaComFotos,
                casaComFotos.getTitulo(),
                420_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        Anuncio anuncioVendaInvalido = new Anuncio(
                casaSemFotos,
                casaSemFotos.getTitulo(),
                380_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        Anuncio anuncioAluguelValido = new Anuncio(
                apartamentoComFotos,
                apartamentoComFotos.getTitulo(),
                2_500,
                TipoNegociacao.ALUGUEL,
                corretor,
                publisher
        );
        // =====================================================
        // 6️⃣ CHAIN OF RESPONSIBILITY
        // =====================================================
        ModeradorAnuncio fotos = new VerificadorFotos();
        ModeradorAnuncio palavras = new VerificadorPalavras();

        fotos.setProximo(palavras);

        ServicoPublicacaoAnuncio servicoPublicacao =
                new ServicoPublicacaoAnuncio(fotos);

        // =====================================================
        // 7️⃣ PUBLICAÇÕES (com sucesso e erro)
        // =====================================================
        System.out.println("🔎 Publicando anúncio de VENDA (válido)...");
        servicoPublicacao.publicar(anuncioVendaValido);
        System.out.println();

        System.out.println("🔎 Publicando anúncio de VENDA (inválido)...");
        servicoPublicacao.publicar(anuncioVendaInvalido);
        System.out.println();

        System.out.println("🔎 Publicando anúncio de ALUGUEL (válido)...");
        servicoPublicacao.publicar(anuncioAluguelValido);
        System.out.println();

        // =====================================================
        // 8️⃣ CONSULTA FINAL (integridade dos dados)
        // =====================================================
        System.out.println("===== CONSULTA DOS ANÚNCIOS =====");

        List<Anuncio> anuncios = List.of(
                anuncioVendaValido,
                anuncioVendaInvalido,
                anuncioAluguelValido
        );

        for (Anuncio a : anuncios) {
            System.out.println("----------------------------------");
            System.out.println("Título: " + a.getTitulo());
            System.out.println("Tipo imóvel: " + a.getItem().getTipo());
            System.out.println("Preço anúncio: R$ " + a.getPreco());
            System.out.println("Tipo negociação: " + a.getTipoNegociacao());
            System.out.println("Tem fotos? " + a.temFotos());
            System.out.println("Estado atual: " +
                    a.getEstado().getClass().getSimpleName());
            System.out.println("Anunciante: " +
                    a.getAnunciante().getNome());
        }


        // =====================================================
// 9️⃣ BUSCA DE USUÁRIO COMUM (DECORATOR)
// =====================================================

        System.out.println("\n===== BUSCA DE ANÚNCIOS (USUÁRIO COMUM) =====");

// 🔹 Montagem dos filtros (Decorator)
        FiltroBusca filtroBusca = new FiltroPrecoMinimo(
                new FiltroPrecoMaximo(
                        new FiltroPorImovel(
                                new BuscaBase(),
                                "Casa"
                        ),
                        500_000
                ),
                300_000
        );

// 🔹 Serviço de busca
        ServicoBusca servicoBusca = new ServicoBusca(filtroBusca);

// 🔹 Usuário comum
        Comprador comprador = new Comprador(
                servicoBusca,
                "Carlos Comprador",
                "carlos@email.com"
        );

// 🔹 Execução da busca
        List<Anuncio> resultados = comprador.buscarAnuncios(anuncios);

// 🔹 Exibição dos resultados
        System.out.println("\n🔎 Resultados encontrados para " + comprador.getNome());

        for (Anuncio a : resultados) {
            System.out.println("----------------------------------");
            System.out.println("Título: " + a.getTitulo());
            System.out.println("Tipo imóvel: " + a.getItem().getTipo());
            System.out.println("Preço: R$ " + a.getPreco());
            System.out.println("Tipo negociação: " + a.getTipoNegociacao());
            System.out.println("Estado: " + a.getEstado().getClass().getSimpleName());
        }












        System.out.println("\n===== FIM DA SIMULAÇÃO =====");
    }















}