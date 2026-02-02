package org.example.Usuario;


import org.example.Anuncio.ServicoBusca;

public class Inquilino extends UsuarioComum {
    public Inquilino(ServicoBusca servicoBusca, String nome, String email) {
        super(servicoBusca, nome, email);
    }
}