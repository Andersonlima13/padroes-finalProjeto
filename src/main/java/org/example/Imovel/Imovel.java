package org.example.Imovel;

import org.example.Anuncio.Anunciavel;
// imovel aqui seria a classe criadora da factory , possuindo uma interface
// anunciavel que te permite ter outros criadores
public abstract class Imovel implements Anunciavel {

    protected String titulo;
    protected double preco;

    // TEMPLATE METHOD
    public final void criarAnuncio() {
        validarCamposObrigatorios();
        coletarCamposEspecificos();
        confirmarCriacao();
    }

    protected void validarCamposObrigatorios() {
        if (titulo == null || preco <= 0) {
            throw new IllegalStateException("Título e preço são obrigatórios");
        }
    }

    protected abstract void coletarCamposEspecificos();

    protected void confirmarCriacao() {
        System.out.println("Anúncio criado com sucesso!");
    }
}
