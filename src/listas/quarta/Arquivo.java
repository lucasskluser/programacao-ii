package listas.quarta;

import java.io.*;

/**
 * Classe responsável por copiar dados de um arquivo para outro
 *
 * @author Lucas Samuel Kluser
 * @since 16/02/2020
 */
public class Arquivo {
    /**
     * Arquivo com os dados que serão copiados
     */
    private File file;

    /**
     * Verifica se o arquivo existe. Caso contrário,
     * lança uma excessão.
     * @param path Arquivo a ser copiado
     * @throws FileNotFoundException
     */
    public Arquivo(String path) throws FileNotFoundException {
        file = new File(path);

        if(!file.exists()) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Retorna uma instância do arquivo a ser copiado
     * @return Arquivo a ser copiado
     */
    public File getFile() {
        return file;
    }

    /**
     * Copia bytes de um arquivo para outro
     * @param path Arquivo que receberá os dados
     * @throws IOException
     */
    public void copyTo(String path) throws IOException {
        File fileToCopy = new File(path);

        if(!fileToCopy.exists()) {
            fileToCopy.createNewFile();
        }

        try (FileInputStream fileInputStream = new FileInputStream(file); FileOutputStream fileOutputStream = new FileOutputStream(fileToCopy)) {
            int content;
            do {
                content = fileInputStream.read();
                fileOutputStream.write(content);
            } while(content != -1);
        }
    }
}
