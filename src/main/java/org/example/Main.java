package org.example;

import org.example.Anuncio.*;
import org.example.Anuncio.FiltroDeBusca.*;
import org.example.Anuncio.Notificacao.*;
import org.example.Anuncio.State.*;
import org.example.Anuncio.VerficadorAnuncios.*;

import org.example.Config.ConfiguracaoSistema;

import org.example.Imovel.Factory.*;
import org.example.Imovel.Imovel;

import org.example.Pagamento.*;
import org.example.Usuario.*;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== SIMULAÇÃO REAL DO SISTEMA =====\n");

        // =====================================================
        // RF07 - SINGLETON (Configurações do Sistema)
        // =====================================================
        System.out.println("⚙️ RF07 - Singleton (Configurações)");

        ConfiguracaoSistema cfg = ConfiguracaoSistema.getInstancia();

        System.out.println("Sistema carregado: " + cfg.isCarregadoComSucesso());
        System.out.println("Preço mínimo venda: " + cfg.getPrecoMinVenda());
        System.out.println("Preço mínimo aluguel: " + cfg.getPrecoMinAluguel());
        System.out.println("Termos proibidos: " + cfg.getTermosProibidos());
        System.out.println("Canal notificação padrão: " + cfg.getCanalNotificacaoPadrao());

        Thread.sleep(1200);

        // =====================================================
        // RF08 - ADAPTER (Planos e Pagamento)
        // =====================================================
        System.out.println("\n💳 RF08 - Adapter (Pagamentos e Planos)");

        Plano planoBasico = new PlanoBasico();
        Plano planoPremium = new PlanoPremium();

        ServicoAssinatura pagamentoPix =
                new ServicoAssinatura(new PixAdapter());

        ServicoAssinatura pagamentoCartao =
                new ServicoAssinatura(new CartaoAdapter());

        System.out.println("Comprador contratando Plano Básico via PIX");
        pagamentoPix.contratarPlano(planoBasico);

        System.out.println("\nInquilino contratando Plano Premium via CARTÃO");
        pagamentoCartao.contratarPlano(planoPremium);

        Thread.sleep(1200);

        // =====================================================
        // RF01 - ANUNCIANTES
        // =====================================================
        System.out.println("\n🧑 RF01 - Anunciantes");

        Anunciante proprietario = new Proprietario(
                "João da Silva",
                "joao@email.com",
                "1199999-9999",
                "123.456.789-00"
        );

        Anunciante corretor = new Corretor(
                "Imobiliária Central",
                "contato@imob.com",
                "113333-4444",
                "12.345.678/0001-99"
        );

        System.out.println("Anunciantes criados:");
        System.out.println("✔ Proprietário: João da Silva | Email: joao@email.com");
        System.out.println("✔ Corretor: Imobiliária Central | Email: contato@imob.com");

        Thread.sleep(1200);

        // =====================================================
        // RF02 - FACTORY METHOD (Imóveis padrão)
        // =====================================================
        System.out.println("\n🏠 RF02 - Factory Method");

        Imovel casaPadrao = new CasaFactory().criarImovel();
        Imovel apPadrao = new ApartamentoFactory().criarImovel();
        Imovel terrenoPadrao = new TerrenoFactory().criarImovel();

        System.out.println("Imóveis criados via Factory:");
        System.out.println("✔ " + casaPadrao.getTitulo() + " | Tipo: Casa");
        System.out.println("✔ " + apPadrao.getTitulo() + " | Tipo: Apartamento");
        System.out.println("✔ " + terrenoPadrao.getTitulo() + " | Tipo: Terreno");

        Thread.sleep(1200);

        // =====================================================
        // OBSERVER (Publisher)
        // =====================================================
        AnuncioPublisher publisher = new AnuncioPublisher();
        publisher.adicionar(new NotificadorWhatsApp());
        publisher.adicionar(new NotificadorEmail());

        // =====================================================
        // RF01 + RF02 - CRIAÇÃO DOS ANÚNCIOS
        // =====================================================
        Anuncio anuncioCasa = new Anuncio(
                casaPadrao,
                casaPadrao.getTitulo(),
                420_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        Anuncio anuncioApartamento = new Anuncio(
                apPadrao,
                apPadrao.getTitulo(),
                2_500,
                TipoNegociacao.ALUGUEL,
                corretor,
                publisher
        );

        Anuncio anuncioTerreno = new Anuncio(
                terrenoPadrao,
                terrenoPadrao.getTitulo(),
                300_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        System.out.println("Anúncios criados:");
        System.out.println("✔ " + anuncioCasa.getTitulo()
                + " | VENDA | R$ 420000 | Estado: "
                + anuncioCasa.getEstado().getClass().getSimpleName());

        System.out.println("✔ " + anuncioApartamento.getTitulo()
                + " | ALUGUEL | R$ 2500 | Estado: "
                + anuncioApartamento.getEstado().getClass().getSimpleName());

        System.out.println("✔ " + anuncioTerreno.getTitulo()
                + " | VENDA | R$ 300000 | Estado: "
                + anuncioTerreno.getEstado().getClass().getSimpleName());

        List<Anuncio> anuncios = List.of(
                anuncioCasa,
                anuncioApartamento,
                anuncioTerreno
        );

        Thread.sleep(1200);

        // =====================================================
        // RF03 - CHAIN OF RESPONSIBILITY (Publicação)
        // =====================================================
        System.out.println("\n🛂 RF03 - Publicação de Anúncios");

        ModeradorAnuncio verificadorFotos = new VerificadorFotos();
        ModeradorAnuncio verificadorPalavras = new VerificadorPalavras();

        verificadorFotos.setProximo(verificadorPalavras);

        ServicoPublicacaoAnuncio publicador =
                new ServicoPublicacaoAnuncio(verificadorFotos);

        publicador.publicar(anuncioCasa);
        publicador.publicar(anuncioApartamento);
        publicador.publicar(anuncioTerreno);

        Thread.sleep(1200);




        // =====================================================
        // RF04 - STATE (Ciclo de Vida – sem transições ilegais)
        // =====================================================
        System.out.println("\n🔄 RF04 - State (Ciclo de Vida)");

        System.out.println("Estado anúncio casa: " +
                anuncioCasa.getEstado().getClass().getSimpleName());

        System.out.println("Estado anúncio apartamento: " +
                anuncioApartamento.getEstado().getClass().getSimpleName());

        System.out.println("Estado anúncio terreno: " +
                anuncioTerreno.getEstado().getClass().getSimpleName());

        Thread.sleep(1200);

        // =====================================================
        // RF03 (NOVAMENTE) - ATIVO → VENDIDO
        // =====================================================
        System.out.println("\n🏷️ RF03 - Encerramento de Anúncio");

        anuncioCasa.vender();

        System.out.println("Novo estado anúncio casa: " +
                anuncioCasa.getEstado().getClass().getSimpleName());

        Thread.sleep(1200);

        // =====================================================
        // RF05 - OBSERVER (com anúncio novo, sem conflito)
        // =====================================================
        System.out.println("\n📢 RF05 - Observer em ação");

        Anuncio anuncioObserver = new Anuncio(
                casaPadrao,
                "Casa Observer",
                500_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        anuncioObserver.enviarParaModeracao();
        anuncioObserver.publicar();
        anuncioObserver.vender();

        Thread.sleep(1200);



        // =====================================================
// RF01 + RF02 + RF03 - ANÚNCIOS ATIVOS PARA BUSCA (RF06)
// =====================================================
        System.out.println("\n🟢 Anúncios extras (ativos) para busca");

// Reaproveitando factories existentes
        Imovel casaBusca = new CasaFactory().criarImovel();
        Imovel apBusca   = new ApartamentoFactory().criarImovel();

// Criando anúncios
        Anuncio anuncioCasaBusca = new Anuncio(
                casaBusca,
                "Casa Ativa para Busca",
                380_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        Anuncio anuncioApBusca = new Anuncio(
                apBusca,
                "Apartamento Ativo para Busca",
                3_000,
                TipoNegociacao.ALUGUEL,
                corretor,
                publisher
        );

// Publicando (ficam ATIVOS)
        publicador.publicar(anuncioCasaBusca);
        publicador.publicar(anuncioApBusca);

// Lista final usada na busca
        List<Anuncio> anunciosParaBusca = List.of(
                anuncioCasaBusca,
                anuncioApBusca
        );

        Thread.sleep(1200);


        // =====================================================
// =====================================================
// RF06 - DECORATOR (Busca Avançada COM filtros)
// =====================================================
        System.out.println("\n🔍 RF06 - Busca com Filtros");

        FiltroBusca filtroComDecorator =
                new FiltroPrecoMinimo(
                        new FiltroPorTipo(
                                new FiltroPorImovel(
                                        new BuscaBase(),
                                        "Casa"
                                ),
                                TipoNegociacao.VENDA
                        ),
                        300_000
                );

        ServicoBusca servicoBuscaFiltrada = new ServicoBusca(filtroComDecorator);

        Comprador compradorFiltrado = new Comprador(
                servicoBuscaFiltrada,
                "Carlos Comprador",
                "carlos@email.com"
        );

        System.out.println("Configuração da busca:");
        System.out.println("- Tipo de imóvel: Casa");
        System.out.println("- Tipo negociação: VENDA");
        System.out.println("- Preço mínimo: R$ 300000");

        List<Anuncio> resultadosFiltrados =
                compradorFiltrado.buscarAnuncios(anunciosParaBusca);

        System.out.println("\nResultados encontrados: " + resultadosFiltrados.size());

        resultadosFiltrados.forEach(a ->
                System.out.println("✔ " + a.getTitulo()
                        + " | Preço: R$ " + a.getPreco()
                        + " | Estado: " + a.getEstado().getClass().getSimpleName())
        );



        // =====================================================
// RF06 - DECORATOR (Busca SEM filtros)
// =====================================================
        System.out.println("\n📋 RF06 - Busca sem filtros (BuscaBase)");

        FiltroBusca buscaSemFiltro = new BuscaBase();

        ServicoBusca servicoBuscaSimples = new ServicoBusca(buscaSemFiltro);

        Comprador compradorSimples = new Comprador(
                servicoBuscaSimples,
                "Visitante",
                "visitante@email.com"
        );

        List<Anuncio> todosResultados =
                compradorSimples.buscarAnuncios(anunciosParaBusca);

        System.out.println("Resultados encontrados: " + todosResultados.size());

        todosResultados.forEach(a ->
                System.out.println("✔ " + a.getTitulo()
                        + " | Tipo: " + a.getImovel().getTipo()
                        + " | Negociação: " + a.getTipoNegociacao()
                        + " | Estado: " + a.getEstado().getClass().getSimpleName())
        );

    }
}
