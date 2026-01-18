package org.example.Anuncio;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;
import org.example.Usuario.Anunciante;

// ENTIDADE ANUNCIO, AQUI , ELA TA MEIO QUE CRUA AINDA, DEFINIMOS QUAL METODO ELA VAI TER E ETC ...




public class Anuncio {
    public void cadastrar(ImovelFactory factory) {
        Imovel imovel = factory.criarImovel();
        imovel.criarAnuncio();
    }

}
