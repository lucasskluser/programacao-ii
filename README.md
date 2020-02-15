# Programação II
Esse repositório foi criado com o propósito de manter os projetos **Java** de exercícios, trabalhos e provas da disciplina de **Programação II**, do curso de **Sistemas de Informação** da **FURB**.

> [!NOTE]
> 
> Os projetos são executas de acordo com as solicitações do professor. Portanto, podem haver maneiras melhores de implementações.

| 
|-
## A organização
Os projetos desse repositório estão organizados da seguinte forma:

1. Pasta fonte
   1. Listas
      1. Listas em número ordinal
         1. Arquivo *Main* da lista
         2. Estrutura interna
   2. Trabalhos
      1.  Trabalhos em número ordinal
          1. Arquivo *Main* do trabalho
          2. Estrutura interna
   3. Provas
      1. Provas em número ordinal
          1. Arquivo *Main* da prova
          2. Estrutura interna
2. Demais arquivos

> [!IMPORTANT]
> O arquivo *Main* de uma lista, prova ou trabalho é responsável pela execução da implementação daquele projeto.

Todo projeto terá um arquivo *Main*, com o nome sendo composto pelo número ordinal + o tipo de projeto (lista, trabalho ou prova) no singular.

Na classe *Main* daquele projeto, haverá um método **run()** responsável por iniciar a execução do projeto.

**Exemplo de organização**

1. src
   1. listas
      1. terceira
         1. TerceiraLista.java *(Main)*
         2. Banco.java
         3. ContaBancaria.java

|
|-

## Como utilizar
1. Baixe o repositório em sua máquina local
2. Na classe Main.java (em **src\\**), execute o método **run()** do projeto desejado.

**Exemplo de execução**
```java
import listas.terceira.TerceiraLista;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TerceiraLista.run();
    }
}
```
|
|---------------------------------
### Maiores informações
**Lucas Samuel Kluser**  
*Autor do repositório*  
lkluser@furb.br
