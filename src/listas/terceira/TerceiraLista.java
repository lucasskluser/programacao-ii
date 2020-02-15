package listas.terceira;

import java.io.IOException;
import java.util.Scanner;

/**
 * Terceira lista de exercícios da disciplina
 * de Programação II
 *
 * @author Lucas Samuel Kluser
 * @since 13/02/2020
 */
public class TerceiraLista {
    public static Banco banco;

    /**
     * Inicia a execução do exercício
     * @throws IOException
     */
    public static void run() throws IOException {
        banco = new Banco();
        String opcao;

        do {
            opcao = imprimeMenu();
            executaOpcao(opcao);
        } while(opcao != null);
    }

    /**
     * Imprime um menu, com opções, no console
     * e retorna a opção escolhida.
     * @return Opção escolhida
     */
    private static String imprimeMenu() {
        System.out.print(
                "========== Menu ===========\n" +
                "a) Inserir conta\n" +
                "b) Listar contas existentes\n" +
                "[enter] Sair\n" +
                "===========================\n" +
                "Escolha uma opção: "
        );

        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    /**
     * Chama o método referente à opção
     * @param opcao Opção a ser executada
     */
    private static void executaOpcao(String opcao) {
        switch (opcao) {
            case "a":
                imprimeCadastroConta();
                break;
            case "b":
                imprimeContasSalvas();
                break;
            default:
                System.exit(0);
        }
    }

    /**
     * Solicita os dados para criação de uma
     * nova conta bancária
     */
    private static void imprimeCadastroConta() {
        Scanner teclado = new Scanner(System.in);
        ContaBancaria contaBancaria = new ContaBancaria();

        try {
            System.out.print("\nQual o número da conta? ");
            contaBancaria.setNumero(teclado.nextLine());

            System.out.print("\nQual o titular da conta? ");
            contaBancaria.setTitular(teclado.nextLine());

            System.out.print("\nQual o saldo da conta? ");
            contaBancaria.setSaldo(teclado.nextDouble());

            banco.salvarConta(contaBancaria);
            System.out.println("Conta cadastrada com sucesso!");
        } catch (IllegalArgumentException exception) {
            System.out.println("\n" + exception.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Imprime as contas já cadastradas
     */
    private static void imprimeContasSalvas() {
        try {
            ContaBancaria[] contasBancarias = banco.obterContas();

            for (ContaBancaria contaBancaria : contasBancarias) {
                    System.out.println("\n" + contaBancaria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
