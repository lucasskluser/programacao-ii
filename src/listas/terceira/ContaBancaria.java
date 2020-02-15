package listas.terceira;

/**
 * Classe responsável por representar o modelo de uma
 * conta bancária
 *
 * @author Lucas Samuel Kluser
 * @since 13/02/2020
 */
public class ContaBancaria {
    /**
     * Número da conta bancária
     */
    private String numero;

    /**
     * Titular da conta bancária
     */
    private String titular;

    /**
     * Saldo da conta bancária
     */
    private double saldo;

    public ContaBancaria() {}

    /**
     * Inicialização rápida da classe
     * @param numero Número da conta bancária
     * @param titular Titular da conta bancária
     * @param saldo Saldo da conta bancária
     */
    public ContaBancaria(String numero, String titular, double saldo) {
        setNumero(numero);
        setTitular(titular);
        setSaldo(saldo);
    }

    /**
     * Retorna o número da conta bancária
     * @return Número da conta bancária
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o número da conta bancária
     * @param numero Número da conta bancária
     * @exception IllegalArgumentException
     */
    public void setNumero(String numero) {
        if (numero.length() < 1) {
            throw new IllegalArgumentException("O número da conta deve ser informado.");
        }

        this.numero = numero;
    }

    /**
     * Retorna o titular da conta bancária
     * @return Titular da conta bancária
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Define o titular da conta bancária
     * @param titular
     * @exception IllegalArgumentException
     */
    public void setTitular(String titular) {
        if (titular.length() < 1) {
            throw new IllegalArgumentException("O titular da conta deve ser informado.");
        }

        this.titular = titular;
    }

    /**
     * Retorna o saldo da conta bancária
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o saldo da conta bancária
     * @param saldo
     * @exception IllegalArgumentException
     */
    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo da conta bancária deve ser maior ou igual a zero.");
        }

        this.saldo = saldo;
    }

    /**
     * Retorna uma representação em String da classe
     * @return Conta bancária no formato String
     */
    @Override
    public String toString() {
        return String.format(
                "Conta: %s\n" +
                "Títular: %s\n" +
                "Saldo: R$ %.2f",
                getNumero(), getTitular(), getSaldo()
        );
    }
}
