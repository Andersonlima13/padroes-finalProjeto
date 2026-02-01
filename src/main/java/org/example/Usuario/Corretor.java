package org.example.Usuario;

public class Corretor extends Anunciante {
    private String cnpj;

    public Corretor(String nome, String email, String telefone, String cnpj) {
        super();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}
