package org.example.Pagamento;


import org.example.Pagamento.GatewayPagamento;

public class ServicoAssinatura {

    private GatewayPagamento gatewayPagamento;

    public ServicoAssinatura(GatewayPagamento gatewayPagamento) {
        this.gatewayPagamento = gatewayPagamento;
    }

    public boolean contratarPlano(Plano plano) {
        System.out.println("💳 Processando pagamento do " + plano.getNome());

        boolean pagamentoOk = gatewayPagamento.pagar(plano.getValor());

        if (pagamentoOk) {
            plano.ativar();
            System.out.println("✅ Plano ativado com sucesso!");
            return true;
        }

        System.out.println("❌ Falha no pagamento.");
        return false;
    }
}
