package org.example.Pagamento;



public abstract class Plano {

    protected String nome;
    protected double valor;
    protected boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    // regra de negócio comum
    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }
}
