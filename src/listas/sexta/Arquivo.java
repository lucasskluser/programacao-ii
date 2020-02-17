package listas.sexta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa o arquivo de dados dos municípios (CSV)
 */
public class Arquivo {
    /**
     * Instância do arquivo de dados
     */
    private File file;

    /**
     * Inicializa o arquivo de dados como uma instância da classe File
     * @param path Diretório do arquivo de dados
     */
    public Arquivo(String path) {
        this.file = new File(path);
    }

    /**
     * Lê o arquivo de dados e retorna todas as linhas em um vetor
     * @return Linhas do arquivo de dados
     * @throws FileNotFoundException
     */
    public String[] lerArquivo() throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            strings.add(scanner.nextLine());
        }

        String[] stringsVetor = new String[strings.size()];
        strings.toArray(stringsVetor);
        return stringsVetor;
    }

    /**
     * Lê o arquivo de dados e desserializa em um objeto da classe Municipio
     * @return Um ArrayList de municipios
     * @throws FileNotFoundException
     */
    public ArrayList<Municipio> lerMunicipios() throws FileNotFoundException {
        ArrayList<Municipio> municipios = new ArrayList<>();

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            scanner.nextLine();

            while (scanner.hasNext()) {
                String[] dados = scanner.nextLine().split(";");

                Municipio municipio = new Municipio(
                        dados[0], dados[1], dados[2], Integer.parseInt(dados[3])
                );

                municipios.add(municipio);
            }
        }

        return municipios;
    }
}
