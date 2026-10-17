package com.leonardobarbosa.javastudy.patterns.singleton.enumeration;

public class EnumSingletonExample {

    /*
    Singleton com Enum -> utiliza um enum com uma única constante
    para garantir uma única instância.

    - A constante representa a instância única.
    - O acesso é feito diretamente pela constante.
    - A implementação é segura para uso concorrente.
    */

    public static void main(String[] args) {

        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        instance1.showMessage();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        System.out.println("Mesma instancia? -> " + (instance1 == instance2));
    }
}
