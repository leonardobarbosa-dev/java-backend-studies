package com.leonardobarbosa.javastudy.oop.initialization.domain;

public class InitializationBlocks {

    /*
    Ordem geral de execução:
    1. Executa tudo  que é static
        - atributos static
        - blocos static
    2. Depois executa tudo que pertence ao objeto
        - atributos de instância -> variáveis que pertencem a cada objeto criado da classe (String name) nesse caso
        - blocos de inicialização
        - construtor

    3. Os blocos executam na ordem que foram criados
        - static 1 -> static 2 -> bloco de instância 1 -> bloco de instância 2
     */

    private String name;
    private final int[] episodes;

    /*
    Bloco de inicialização estático
    - Executa apenas uma vez quando a classe é criada
     */

    static {
        System.out.println("Bloco de inicialização estático");
    }

    /*
    Bloco de inicialização de instancia:
    - Executa toda vez que o objeto é criado

    - Ordem de execução:
    1. atributos recebem valores padrão
    2. blocos de inicialização executam
    3. construtor executa
     */

    {
        System.out.println("Bloco de inicialização de instancia");

        episodes = new int[44];
        for (int i = 0; i < episodes.length; i++) {
            episodes[i] = i+1;
        }
    }

    /*
    Se caso existir vários construtores e todos precisarem usar o array,
    evita repetição usando bloco de inicialização
     */

    // Construtores
    public InitializationBlocks() {
        System.out.println("Construtor Executado");
    }

    public InitializationBlocks(String name) {
        this.name = name;
        System.out.println("Construtor 2 Executado");
    }


    // Imprimir nome e episódios
    public void printEpisodes() {
        System.out.println("Anime: " + this.name);
        for (int episode : episodes) {
            System.out.print(episode + " ");
        }
        System.out.println("\n");
    }
}
