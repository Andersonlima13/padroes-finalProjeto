package org.example.Anuncio;

import org.example.Imovel.Imovel;
import org.example.Imovel.ImovelFactory;


// anuncio é cliente de imovel, seguindo os rf01 e rf02


public class Anuncio {
    public void cadastrar(ImovelFactory factory) {
        Imovel imovel = factory.criarImovel();
        imovel.criarAnuncio();
    }

}
