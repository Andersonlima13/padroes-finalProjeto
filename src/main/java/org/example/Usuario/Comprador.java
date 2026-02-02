package org.example.Usuario;


import org.example.Anuncio.ServicoBusca;

public class Comprador extends UsuarioComum {
    public Comprador(ServicoBusca servicoBusca, String nome, String email) {
        super(servicoBusca, nome, email);
    }
}