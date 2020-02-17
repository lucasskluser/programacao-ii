package listas.sexta;

import java.util.ArrayList;

/**
 * Faça o download do arquivo municípios.csv que está no AVA. Este arquivo contém dados dos municípios do Brasil. O
 * arquivo, em formato texto e codificado com UTF-8, consiste numa matriz de quatro colunas, onde cada coluna consiste
 * num dado de um município. A primeira linha do arquivo contém os nomes dos dados. Cada coluna é separada pelo
 * caractere “;”.
 *
 * Projete e escreva um programa que leia este arquivo. Após a leitura do arquivo, exiba os seguintes dados:
 * • A cidade com menor população
 * • A cidade com maior população
 */
public class SextaLista {
    public static void run() {
        imprimeCidadeMenorPopulacao();
        imprimeCidadeMaiorPopulacao();
    }

    /**
     * Imprime todos os municípios no arquivo de dados
     */
    private static void imprimeMunicipios() {
        Arquivo arquivo = new Arquivo("data\\municipios.csv");

        try {
            ArrayList<Municipio> municipios = arquivo.lerMunicipios();
            municipios.forEach(municipio -> System.out.println(municipio));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime o município com a menor população no arquivo de dados
     */
    private static void imprimeCidadeMenorPopulacao() {
        Arquivo arquivo = new Arquivo("data\\municipios.csv");
        int menorPopulacao = Integer.MAX_VALUE;
        Municipio municipio = new Municipio();

        try {
            ArrayList<Municipio> municipios = arquivo.lerMunicipios();

            for (Municipio m : municipios) {
                if (m.getPopulacao() < menorPopulacao) {
                    menorPopulacao = m.getPopulacao();
                    municipio = m;
                }
            }

            System.out.println(String.format("Município com menor população: %s", municipio.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime o município com a maior população no arquivo de dados
     */
    private static void imprimeCidadeMaiorPopulacao() {
        Arquivo arquivo = new Arquivo("data\\municipios.csv");
        int maiorPopulacao = Integer.MIN_VALUE;
        Municipio municipio = new Municipio();

        try {
            ArrayList<Municipio> municipios = arquivo.lerMunicipios();

            for (Municipio m : municipios) {
                if (m.getPopulacao() > maiorPopulacao) {
                    maiorPopulacao = m.getPopulacao();
                    municipio = m;
                }
            }

            System.out.println(String.format("Município com maior população: %s", municipio.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
