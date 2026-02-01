package org.example.Pagamento;

import org.example.Pagamento.Api.PixApiExterna;

public class PixAdapter implements GatewayPagamento {

    private PixApiExterna pixApi;

    public PixAdapter() {
        this.pixApi = new PixApiExterna();
    }

    @Override
    public boolean pagar(Double valor) {
        return pixApi.efetuarPix(valor);
    }
}
