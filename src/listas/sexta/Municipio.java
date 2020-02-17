package listas.sexta;

/**
 * Classe que representa um município do arquivo de dados
 */
public class Municipio {
    /**
     * Código IBGE do município
     */
    private String codigoIbge;

    /**
     * Nome do município
     */
    private String nome;

    /**
     * Estado do município
     */
    private String estado;

    /**
     * Número da população do município
     */
    private int populacao;

    public Municipio() {}

    /**
     * Inicializa um objeto da classe Municipio
     * @param codigoIbge Código IBGE do município
     * @param nome Nome do município
     * @param estado Estado do município
     * @param populacao População do município
     */
    public Municipio(String codigoIbge, String nome, String estado, int populacao) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
    }

    /**
     * @return Código IBGE
     */
    public String getCodigoIbge() {
        return codigoIbge;
    }

    /**
     * Define o código IBGE do município
     * @param codigoIbge Código IBGE
     */
    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    /**
     * @return Nome do município
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do município
     * @param nome Nome do município
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Estado do município
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado do município
     * @param estado Estado do município
     */
    public void setEstado(String estado) {
        this.estado = estado.trim();
    }

    /**
     * @return População do município
     */
    public int getPopulacao() {
        return populacao;
    }

    /**
     * Define a população do município
     * @param populacao População do município
     */
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    /**
     * Retorna uma representação escrita do objeto
     * @return Objeto no formato String
     */
    @Override
    public String toString() {
        return String.format(
                "(%s) Cidade de %s/%s com %d habitantes",
                getCodigoIbge(), getNome(), getEstado(), getPopulacao()
        );
    }
}
