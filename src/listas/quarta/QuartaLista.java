package listas.quarta;

import java.io.File;
import java.io.IOException;

/**
 * Quarta lista de exercícios da disciplina
 * de Programação II
 *
 * @author Lucas Samuel Kluser
 * @since 16/02/2020
 */
public class QuartaLista {
    /**
     * Inicia a execução do exercício
     * @throws IOException
     */
    public static void run() {
        File directory = new File("temp");

        if (!directory.exists()) {
            directory.mkdir();
        }

        try {
            Arquivo arquivo = new Arquivo("temp\\contas.bin");
            arquivo.copyTo("temp\\contas2.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}