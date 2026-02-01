package org.example.Usuario;



public abstract class Anunciante {

    protected String nome;
    protected String email;
    protected String telefone;

    protected Anunciante(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Anunciante() {

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
