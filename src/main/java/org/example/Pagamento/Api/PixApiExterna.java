package org.example.Pagamento.Api;

public class PixApiExterna {

    public boolean efetuarPix(double valor) {
        System.out.println("⚡ Pagamento via PIX efetuado: R$ " + valor);
        return true; // simulação
    }
}