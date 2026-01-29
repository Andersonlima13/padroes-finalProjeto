package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;
// interface do chain , requisito 3

public interface ModeradorAnuncio {
    void moderar(Anuncio anuncio);
    ModeradorAnuncio setProximo(ModeradorAnuncio proximo);
}