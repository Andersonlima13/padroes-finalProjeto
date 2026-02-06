package org.example;

import org.example.Anuncio.*;
import org.example.Anuncio.FiltroDeBusca.*;
import org.example.Anuncio.Notificacao.*;
import org.example.Anuncio.State.*;
import org.example.Anuncio.VerficadorAnuncios.*;

import org.example.Config.ConfiguracaoSistema;

import org.example.Imovel.Factory.*;
import org.example.Imovel.Imovel;

import org.example.Imovel.ImovelFactory;
import org.example.Pagamento.*;
import org.example.Usuario.*;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== SIMULAÇÃO REAL DO SISTEMA =====\n");

        // =====================================================
        // RF07 - SINGLETON (Configurações do Sistema)
        // =====================================================

        Thread.sleep(1200);


        System.out.println("⚙️ RF07 - Singleton (Configurações)");

        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();

        System.out.println("Sistema carregado: " + config.isCarregadoComSucesso());
        System.out.println("Preço mínimo venda: " + config.getPrecoMinVenda());
        System.out.println("Preço mínimo aluguel: " + config.getPrecoMinAluguel());
        System.out.println("Termos proibidos: " + config.getTermosProibidos());
        System.out.println("Canal notificação padrão: " + config.getCanalNotificacaoPadrao());

        System.out.println("Tipo de Casa Padrão : " + config.getCasaTituloPadrao());
        System.out.println("Quintal de Casa Padrão : " + config.isCasaPossuiQuintalPadrao());

        System.out.println("Titulo de Apartamento Padrão : " + config.getApartamentoTituloPadrao());
        System.out.println("Numero de quartos apartamento Padrão : " + config.getApartamentoQuartosPadrao());
        System.out.println("Elevador padrão de apartamento : " + config.isApartamentoPossuiElevadorPadrao());

        System.out.println("Terreno padrão   : " + config.getTerrenoTituloPadrao());
        System.out.println("Terreno Area padrão  : " + config.getTerrenoAreaPadrao());








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
        // RF01 E RF02 - FACTORY METHOD  (Imóveis padrão)
        // =====================================================
        System.out.println("\n🏠 RF02 - Factory Method");


        // CRIANDO IMOVEIS PADRONIZADOS

        Imovel casaPadrao = new CasaFactory().criarImovel();
        Imovel apPadrao = new ApartamentoFactory().criarImovel();
        Imovel terrenoPadrao = new TerrenoFactory().criarImovel();

        // Criando factorys personalizadas
        CasaFactory factoryCasa = new CasaFactory();

        Imovel casaCustom1 = factoryCasa.criarImovel(
                "Casa 2 quartos com quintal",
                true
        );

        Imovel casaCustom2 = factoryCasa.criarImovel(
                "Casa 3 quartos sem quintal",
                false
        );

        Imovel casaCustom3 = factoryCasa.criarImovel(
                "Casa 4 quartos sem quintal",
                false
        );

        ApartamentoFactory factoryApartamento = new ApartamentoFactory();

        Imovel apartamentoCustom1 = factoryApartamento.criarImovel(
                "apartamento 2 quartos",
                2,
                false
        );

        Imovel apartamentoCustom2 = factoryApartamento.criarImovel(
                "apartamento 3 quartos",
                3,
                false
        );


        Imovel apartamentoCustom3 = factoryApartamento.criarImovel(
                "apartamento 4 quartos",
                4,
                true
        );


        TerrenoFactory factoryTerreno = new TerrenoFactory();

        Imovel terrenoCustom1 = factoryTerreno.criarImovel(
                "Terreno de 500",
                500
        );

        Imovel terrenoCustom2 = factoryTerreno.criarImovel(
                "Terreno de 600",
                600
        );

        Imovel terrenoCustom3 = factoryTerreno.criarImovel(
                "Terreno de 700",
                700
        );



        System.out.println("✔ " + casaPadrao.getTitulo() + " | Tipo: Casa padronizada");


        System.out.println("Imóveis criados via Factory:");
        System.out.println("✔ " + casaCustom1.getTitulo() + " | Tipo: casaCustom1");
        System.out.println("✔ " + casaCustom2.getTitulo() + " | Tipo: casaCustom2 ");
        System.out.println("✔ " + casaCustom3.getTitulo() + " | Tipo: casaCustom3");


        System.out.println("✔ " + apPadrao.getTitulo() + " | Tipo: Apartamento Padronizado");


        System.out.println("✔ " + apartamentoCustom1.getTitulo() + " | Tipo: Apartamento Custom");
        System.out.println("✔ " + apartamentoCustom2.getTitulo() + " | Tipo: Apartamento Custom");
        System.out.println("✔ " + apartamentoCustom3.getTitulo()+ " | Tipo: Apartamento Custom");




        System.out.println("✔ " + terrenoPadrao.getTitulo().getClass().getSimpleName() + " | Tipo: Terreno Padronizado");

        System.out.println("✔ " + terrenoCustom1.getTitulo().getClass().getSimpleName() + " | Tipo: Terreno custom 1");
        System.out.println("✔ " + terrenoCustom2.getTitulo().getClass().getSimpleName() + " | Tipo: Terreno custom 2");
        System.out.println("✔ " + terrenoCustom3.getTitulo().getClass().getSimpleName() + " | Tipo: Terreno custom  3" );


        Thread.sleep(1200);

        // =====================================================
        // OBSERVER (Publisher) --- adcionando notificadores
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


        Anuncio anuncioCasaCustom1 = new Anuncio(
                casaCustom1,
                casaCustom1.getTitulo(),
                420_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );

        Anuncio anuncioCasaCustom2 = new Anuncio(
                casaCustom2,
                casaCustom2.getTitulo(),
                420_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );


        Anuncio anuncioCasaCustom3 = new Anuncio(
                casaCustom3,
                casaCustom3.getTitulo(),
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
                + anuncioCasa.getEstado().getClass().getSimpleName());

        System.out.println("✔ " + anuncioApartamento.getTitulo()
                + anuncioApartamento.getEstado().getClass().getSimpleName());

        System.out.println("✔ " + anuncioTerreno.getTitulo()
                + anuncioTerreno.getEstado().getClass().getSimpleName());


        System.out.println("✔ " + anuncioCasaCustom1.getTitulo()
                + anuncioTerreno.getEstado().getClass().getSimpleName());

        System.out.println("✔ " + anuncioCasaCustom2.getTitulo()
                + anuncioTerreno.getEstado().getClass().getSimpleName());

        System.out.println("✔ " + anuncioCasaCustom3.getTitulo()
                + anuncioTerreno.getEstado().getClass().getSimpleName());





        Thread.sleep(1200);

        // =====================================================
        // RF03 RF04 - CHAIN OF RESPONSIBILITY + STATE (Publicação)
        // =====================================================
        System.out.println("\n🛂 RF03 - Publicação de Anúncios");

        ModeradorAnuncio verificadorFotos = new VerificadorFotos();
        ModeradorAnuncio verificadorPalavras = new VerificadorPalavras();
        ModeradorAnuncio verificadorPreco = new VerificadorPreco();

        verificadorFotos.setProximo(verificadorPalavras);
        verificadorPalavras.setProximo(verificadorPreco);

        ServicoPublicacaoAnuncio publicador =  new ServicoPublicacaoAnuncio(verificadorFotos);


        System.out.println("\n Demonstrando o ciclo de vida de um anuncio");

        System.out.println("AnuncioCasaCustom1 Antes de publicar : " + anuncioCasaCustom1.
                getEstado().getClass().getSimpleName());

        publicador.publicar(anuncioCasaCustom1);


        System.out.println("AnuncioCasaCustom1 dps de publicar estado : " + anuncioCasaCustom1.
                getEstado().getClass().getSimpleName());;


        publicador.publicar(anuncioCasaCustom2);
        publicador.publicar(anuncioCasaCustom3);
        publicador.publicar(anuncioCasa);
        publicador.publicar(anuncioApartamento);
        publicador.publicar(anuncioTerreno);

        System.out.println("Publicando demais anuncios :  " + anuncioCasaCustom2.getTitulo()
                .getClass().getSimpleName()+ anuncioCasaCustom2.getEstado().getClass().getSimpleName());
        System.out.println("Publicando demais anuncios :  " + anuncioCasaCustom3.getTitulo().getClass().getSimpleName()
                + anuncioCasaCustom3.getEstado().getClass().getSimpleName());
        System.out.println("Publicando demais anuncios :  " + anuncioCasa.getTitulo().getClass().getSimpleName()
                + anuncioCasa.getEstado().getClass().getSimpleName());
        System.out.println("Publicando demais anuncios :  " + anuncioApartamento.getTitulo().getClass().getSimpleName()
                + anuncioApartamento.getEstado().getClass().getSimpleName());
        System.out.println("Publicando demais anuncios :  " + anuncioTerreno.getTitulo().getClass().getSimpleName()
                + anuncioTerreno.getEstado().getClass().getSimpleName());






        Thread.sleep(1200);









        Thread.sleep(1200);

        // =====================================================
        // RF03 (NOVAMENTE) - ATIVO → VENDIDO
        // =====================================================
        System.out.println("\n🏷️ RF03 - Encerramento de Anúncio");



        anuncioCasa.vender();

        System.out.println("Novo estado anúncio Casa: " +
                anuncioCasa.getEstado().getClass().getSimpleName());

        Thread.sleep(1200);

        // =====================================================
        // RF05 - OBSERVER (com anúncio novo, sem conflito)
        // =====================================================
        System.out.println("\n📢 RF05 - Observer em ação");


        Imovel casaobserver = new CasaFactory().criarImovel();

        Anuncio anuncioObserver = new Anuncio(
                casaobserver,
                "Casa Exemplo para observer",
                500_000,
                TipoNegociacao.VENDA,
                proprietario,
                publisher
        );



        anuncioObserver.enviarParaModeracao();
        anuncioObserver.publicar();
        anuncioObserver.vender();

        Thread.sleep(1200);





        // DEMONSTRAR O RF 06 --> Reunindo todos os anuncios criandos em uma lista


        List<Anuncio> anunciosParaBusca = List.of(
                anuncioCasaCustom1,
                anuncioCasaCustom2,
                anuncioCasaCustom3
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
                                TipoNegociacao.ALUGUEL
                        ),
                        300_000
                );



        ServicoBusca servicoBuscaFiltrada = new ServicoBusca(filtroComDecorator);

        // Usuario a filtrar a busca

        Comprador compradorFiltrado = new Comprador(
                servicoBuscaFiltrada,
                "Carlos Comprador",
                "carlos@email.com"
        );


        // filtros utilizados

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
