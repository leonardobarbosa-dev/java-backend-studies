package com.leonardobarbosa.javastudy.innerclasses.anonymous;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface Greeting {
    void great(String name);
}

public class AnonymousClassExample {
    public static void main(String[] args) {

        /*
        Classe anônima -> implementa uma interface ou estende uma classe
        diretamente no ponto de uso, sem criar um arquivo .java separado
        - não tem nome
        - definida e instanciada ao mesmo tempo
        - predecessor das lambdas (Java 8+)
         */

        // implementando a interface Greeting com uma classe anônima
        Greeting formal = new Greeting() {
            @Override
            public void great(String name) {
                System.out.println("Bom dia " + name);
            }
        };

        Greeting informal = new Greeting() {
            @Override
            public void great(String name) {
                System.out.println("E ai " + name);
            }
        };

        formal.great("John");
        informal.great("Leon");


        /*
        Uso clássico antes do Java 8: Comparator como classe anônima
        - hoje substituído por lambda, mas ainda aparece em código legado
         */

        List<String> names = new ArrayList<>(List.of("Pedro", "Ana", "Carlos", "Bia"));

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("ordenado por classe anônima -> " + names);

        // equivalente com lambda (Java 8+)
        names.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println("ordenado por lambda         -> " + names);

    }
}
