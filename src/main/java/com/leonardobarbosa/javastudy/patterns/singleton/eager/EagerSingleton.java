package com.leonardobarbosa.javastudy.patterns.singleton.eager;

public class EagerSingleton {

    /*
    Eager Initialization -> a instância é criada durante a
    inicialização da classe.

    - Construtor privado impede a criação externa de instâncias.
    - Atributo static mantém uma única instância compartilhada.
    - getINSTANCE() fornece acesso à instância.
    */

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getINSTANCE() {
        return INSTANCE;
    }
}
