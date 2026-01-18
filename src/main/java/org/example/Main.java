package org.example;

import org.example.Anuncio.Anuncio;
import org.example.Imovel.Factory.ApartamentoFactory;
import org.example.Imovel.Factory.CasaFactory;
import org.example.Imovel.Factory.TerrenoFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Anuncio anuncio = new Anuncio();

        anuncio.cadastrar(new CasaFactory());
        anuncio.cadastrar(new ApartamentoFactory());
        anuncio.cadastrar(new TerrenoFactory());
        }
    }
