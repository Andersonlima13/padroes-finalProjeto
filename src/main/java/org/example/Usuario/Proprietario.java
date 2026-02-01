package org.example.Usuario;

public class Proprietario extends Anunciante {
    private String cpf;

    public Proprietario(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}