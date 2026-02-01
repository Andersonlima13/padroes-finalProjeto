package org.example.Pagamento.Api;

public class CartaoApiExterna {

    public boolean realizarPagamentoCartao(double valor) {
        System.out.println("💳 Pagamento via CARTÃO processado: R$ " + valor);
        return true; // simulação de sucesso
    }
}