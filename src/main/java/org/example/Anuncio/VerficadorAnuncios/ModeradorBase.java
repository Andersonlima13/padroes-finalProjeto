package org.example.Anuncio.VerficadorAnuncios;

import org.example.Anuncio.Anuncio;
// base handler, rf02
public abstract class ModeradorBase implements ModeradorAnuncio {

    protected ModeradorAnuncio proximo;

    @Override
    public ModeradorAnuncio setProximo(ModeradorAnuncio proximo) {
        this.proximo = proximo;
        return proximo; // permite encadeamento fluente
    }

    protected void passarParaProximo(Anuncio anuncio) {
        if (proximo != null) {
            proximo.moderar(anuncio);
        } else {
            System.out.println("✅ Anúncio aprovado em todas as validações.");
        }
    }
}
