package listas.terceira;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar contas bancárias
 *
 * Essa classe possui métodos para gravar e ler contas
 * em um arquivo com formato próprio.
 *
 * @author Lucas Samuel Kluser
 * @since 13/02/2020
 */
public class Banco {
    /**
     * Caminho para o arquivo de dados
     *
     * Atributo responsável por armazenar o endereço para o
     * arquivo que contém as contas bancárias.
     */
    private final static String filePath = "temp\\contas.bin";

    /**
     * Arquivo de dados
     *
     * Atributo responsável por manter a instância do arquivo
     * de dados.
     */
    private File file;

    /**
     * Leitor de dados
     *
     * Atributo responsável por manter a instância da classe
     * que faz a leitura do arquivo de dados.
     */
    private DataInputStream dataInputStream;

    /**
     * Escritor de dados
     *
     * Atributo responsável por manter a instância da classe
     * que faz a escrita no arquivo de dados.
     */
    private DataOutputStream dataOutputStream;

    /**
     * Verifica se o diretório e arquivo existem e,
     * caso contrário, cria eles.
     * @throws IOException
     */
    public Banco() throws IOException {
        file = new File(filePath);

        if(!file.exists()) {
            if (!file.isDirectory()) {
                File directory = new File("etc");
                directory.mkdir();
            }

            file.createNewFile();
        }
    }

    /**
     * Retorna a classe responsável pela leitura dos dados
     * @return Classe de leitura dos dados
     */
    private DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    /**
     * Instancia a classe responsável pela leitura dos dados.
     * @param file Arquivo de dados
     * @throws FileNotFoundException
     */
    private void setDataInputStream(File file) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        dataInputStream = new DataInputStream(fileInputStream);
    }

    /**
     * Retorna a classe responsável pela escrita dos dados
     * @return Classe de escrita dos dados
     */
    private DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    /**
     * Instancia a classe responsável pela escrita dos dados
     * @param file Arquivo de dados
     * @throws FileNotFoundException
     */
    private void setDataOutputStream(File file) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        dataOutputStream = new DataOutputStream(fileOutputStream);
    }

    /**
     * Inclui os dados da conta bancária no arquivo de dados
     * @param contaBancaria Conta a ser salva
     * @throws IOException
     */
    public void salvarConta(ContaBancaria contaBancaria) throws IOException {
            setDataOutputStream(this.file);

            getDataOutputStream().writeUTF(contaBancaria.getNumero());
            getDataOutputStream().writeUTF(contaBancaria.getTitular());
            getDataOutputStream().writeDouble(contaBancaria.getSaldo());

            getDataOutputStream().close();
    }

    /**
     * Retorna as contas bancárias incluídas no arquivo de dados.
     * @return Contas bancárias
     * @throws IOException
     */
    public ContaBancaria[] obterContas() throws IOException {
        ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();
        setDataInputStream(this.file);

        try {
            do {
                ContaBancaria contaBancaria = new ContaBancaria(
                        getDataInputStream().readUTF(),
                        getDataInputStream().readUTF(),
                        getDataInputStream().readDouble()
                );

                contasBancarias.add(contaBancaria);
            } while (true);
        } catch (EOFException eof) {
            // O ArrayList é convertido para vetor porque qualquer
            // usuário dessa classe poderia utilizar os dados da forma
            // mais simples possível
            ContaBancaria[] contasBancariasVetor = new ContaBancaria[contasBancarias.size()];
            contasBancarias.toArray(contasBancariasVetor);
            return contasBancariasVetor;
        } catch (IOException io) {
            throw io;
        } finally {
            getDataInputStream().close();
        }
    }
}
