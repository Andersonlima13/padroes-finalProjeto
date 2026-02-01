package org.example.Pagamento;

import org.example.Pagamento.Api.CartaoApiExterna;

public class CartaoAdapter implements GatewayPagamento {

    private CartaoApiExterna cartaoApi;

    public CartaoAdapter() {
        this.cartaoApi = new CartaoApiExterna();
    }

    @Override
    public boolean pagar(Double valor) {
        return cartaoApi.realizarPagamentoCartao(valor);
    }
}