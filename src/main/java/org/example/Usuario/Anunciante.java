package org.example.Usuario;



public abstract class Anunciante {

    protected String nome;
    protected String email;
    protected String telefone;



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
