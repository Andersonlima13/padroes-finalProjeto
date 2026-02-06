package org.example.Config;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * PADRÃO: Singleton
 * PAPEL: Singleton
 * FUNÇÃO: Centralizar configurações do sistema (RF07)
 */
public class ConfiguracaoSistema {

    private static final String ARQUIVO_CONFIG = "config.properties";

    private final Properties propriedades = new Properties();
    private final boolean carregadoComSucesso;

    // Construtor privado
    private ConfiguracaoSistema() {
        this.carregadoComSucesso = carregar();
    }

    // Holder (thread-safe)
    private static class Holder {
        private static final ConfiguracaoSistema INSTANCIA =
                new ConfiguracaoSistema();
    }

    public static ConfiguracaoSistema getInstancia() {
        return Holder.INSTANCIA;
    }

    private boolean carregar() {
        try (InputStream is =
                     getClass().getClassLoader().getResourceAsStream(ARQUIVO_CONFIG)) {

            if (is == null) {
                carregarPadrao();
                return true;
            }

            propriedades.load(is);
            return true;

        } catch (Exception e) {
            carregarPadrao();
            return false;
        }
    }

    private void carregarPadrao() {

        // Sistema
        propriedades.setProperty("sistema.nome", "MyHome");
        propriedades.setProperty("sistema.versao", "1.0");

        // Anúncio
        propriedades.setProperty("anuncio.limite.fotos", "20");
        propriedades.setProperty("anuncio.titulo.min", "10");
        propriedades.setProperty("anuncio.titulo.max", "100");
        propriedades.setProperty("anuncio.descricao.min", "20");
        propriedades.setProperty("anuncio.descricao.max", "3000");

        // Preços
        propriedades.setProperty("preco.venda.min", "10000");
        propriedades.setProperty("preco.aluguel.min", "100");
        propriedades.setProperty("preco.max", "500000000");

        propriedades.setProperty("imovel.casa.titulo", "Casa comum com quintal");
        propriedades.setProperty("imovel.casa.possuiQuintal", "true");


        propriedades.setProperty("imovel.apartamento.titulo", "Apartamento Central");
        propriedades.setProperty("imovel.apartamento.quartos", "3");
        propriedades.setProperty("imovel.apartamento.possuiElevador", "true");


        propriedades.setProperty("imovel.terreno.titulo", "Terreno simples");
        propriedades.setProperty("imovel.terreno.area", "100");


        // Moderação
        propriedades.setProperty(
                "moderacao.termos",
                "golpe,fraude,spam,grátis"
        );

        // Notificação
        propriedades.setProperty("notificacao.canal", "EMAIL");



        // casa

        // Imóveis - Casa


    }

    // ================== GETTERS ==================

    public int getLimiteFotos() {
        return getInt("anuncio.limite.fotos", 20);
    }

    public int getTituloMin() {
        return getInt("anuncio.titulo.min", 10);
    }

    public int getTituloMax() {
        return getInt("anuncio.titulo.max", 100);
    }

    public int getDescricaoMin() {
        return getInt("anuncio.descricao.min", 20);
    }

    public int getDescricaoMax() {
        return getInt("anuncio.descricao.max", 3000);
    }

    public double getPrecoMinVenda() {
        return getDouble("preco.venda.min", 10000);
    }

    public double getPrecoMinAluguel() {
        return getDouble("preco.aluguel.min", 100);
    }

    public double getPrecoMax() {
        return getDouble("preco.max", 500000000);
    }


    public String getCasaTituloPadrao() {
        return propriedades.getProperty(
                "imovel.casa.titulo",
                "Casa titulo"
        );
    }




    public boolean isCasaPossuiQuintalPadrao() {
        return Boolean.parseBoolean(
                propriedades.getProperty(
                        "imovel.casa.possuiQuintal",
                        "true"
                )
        );
    }

    public String getApartamentoTituloPadrao() {
        return propriedades.getProperty(
                "imovel.apartamento.titulo",
                "Apartamento"
        );
    }

    public boolean isApartamentoPossuiElevadorPadrao() {
        return Boolean.parseBoolean(
                propriedades.getProperty(
                        "imovel.apartamento.possuiElevador",
                        "false"
                )
        );
    }

    public int getApartamentoQuartosPadrao() {
        return getInt(
                "imovel.apartamento.quartos",
                2
        );
    }


    public String getTerrenoTituloPadrao() {
        return propriedades.getProperty(
                "imovel.terreno.titulo",
                "Terreno"
        );
    }

    public int getTerrenoAreaPadrao() {
        return getInt(
                "imovel.terreno.area",
                0
        );
    }





    public List<String> getTermosProibidos() {
        String termos = propriedades.getProperty("moderacao.termos", "");
        return Arrays.stream(termos.split(","))
                .map(String::trim)
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }

    public String getCanalNotificacaoPadrao() {
        return propriedades.getProperty("notificacao.canal", "EMAIL");
    }

    public boolean isCarregadoComSucesso() {
        return carregadoComSucesso;
    }






    // ================== AUX ==================

    private int getInt(String chave, int padrao) {
        try {
            return Integer.parseInt(propriedades.getProperty(chave));
        } catch (Exception e) {
            return padrao;
        }
    }

    private double getDouble(String chave, double padrao) {
        try {
            return Double.parseDouble(propriedades.getProperty(chave));
        } catch (Exception e) {
            return padrao;
        }
    }
}