package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.example.Usuario.*;
import org.example.Pagamento.*;
import org.example.Anuncio.*;
import org.example.Anuncio.VerficadorAnuncios.*;
import org.example.Anuncio.Notificacao.*;
import org.example.Imovel.Tipo.*;
import org.example.Anuncio.State.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== SIMULAÇÃO REAL DO SISTEMA =====");

        // =====================================================
        // 1️⃣ USUÁRIO ANUNCIANTE
        // =====================================================
        Anunciante proprietario = new Proprietario();

        // =====================================================
        // 2️⃣ ESCOLHA DO PLANO
        // =====================================================
        Plano plano = new PlanoBasico();

        // =====================================================
        // 3️⃣ PAGAMENTO (Adapter + Strategy)
        // =====================================================
        GatewayPagamento gatewayPagamento = new CartaoAdapter();
        ServicoAssinatura servicoAssinatura =
                new ServicoAssinatura(gatewayPagamento);

        if (!servicoAssinatura.contratarPlano(plano)) {
            System.out.println("🚫 Assinatura não concluída.");
            return;
        }

        // =====================================================
        // 4️⃣ CRIAÇÃO DO IMÓVEL (Factory / Produto)
        // =====================================================
        Casa casa = new Casa(
                "Casa com quintal e garagem",
                420_000.00,
                true

        );

        // =====================================================
        // 5️⃣ OBSERVER (Publisher + Subscribers)
        // =====================================================
        AnuncioPublisher publisher = new AnuncioPublisher();
        publisher.adicionar(new NotificadorWhatsApp());

        // =====================================================
        // 6️⃣ CRIAÇÃO DO ANÚNCIO (feito pelo anunciante)
        // =====================================================
        Anuncio anuncio = new Anuncio(
                casa,
                casa.getTitulo(),
                proprietario,
                publisher
        );

        System.out.println("📌 Anúncio criado por: " + anuncio.getAnunciante());

        // =====================================================
        // 7️⃣ CHAIN OF RESPONSIBILITY
        // =====================================================
        ModeradorAnuncio fotos = new VerificadorFotos();
        ModeradorAnuncio palavras = new VerificadorPalavras();

        fotos.setProximo(palavras);

        // =====================================================
        // 8️⃣ SERVIÇO DE PUBLICAÇÃO
        // =====================================================
        ServicoPublicacaoAnuncio servicoPublicacao =
                new ServicoPublicacaoAnuncio(fotos);

        // =====================================================
        // 9️⃣ PUBLICAÇÃO
        // =====================================================
        servicoPublicacao.publicar(anuncio);

        System.out.println("===== FIM DA SIMULAÇÃO =====");
    }
}