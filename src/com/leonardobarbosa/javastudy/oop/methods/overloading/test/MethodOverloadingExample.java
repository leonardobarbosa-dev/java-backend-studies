package com.leonardobarbosa.javastudy.oop.methods.overloading.test;

import com.leonardobarbosa.javastudy.oop.methods.overloading.domain.MethodOverloading;

public class MethodOverloadingExample {
    public static void main(String[] args) {

        /*
        A sobrecarga acontece pela assinatura do metodo,
        não pelo tipo de retorno.

        A assinatura considera:
        - nome do metodo
        - quantidade de parâmetros
        - tipos de parâmetros
        - ordem dos parâmetros
         */
        MethodOverloading anime = new MethodOverloading();

        anime.init("Vinland Saga", "Ação/Histórico", 2);
        anime.print();

        anime.init("Death Note", "Investigação", 2, 44);
        anime.print();
    }
}
