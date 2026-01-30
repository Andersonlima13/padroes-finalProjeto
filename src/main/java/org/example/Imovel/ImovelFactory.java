package org.example.Imovel;

import org.example.Anuncio.Anunciavel;
// imovel aqui seria a classe criadora da factory , possuindo uma interface
// anunciavel que te permite ter outros criadores
public abstract class ImovelFactory {
    public abstract Imovel criarImovel();
}