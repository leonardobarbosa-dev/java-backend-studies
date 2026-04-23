package com.leonardobarbosa.javastudy.exceptions.flow;

public class ExceptionPropagationExample {
    public static void main(String[] args) {

        /*
        Objetivo: Ver a exception subindo a stack sem tratamento

        - O erro nasce em methodTwo();
        - Sobe para o main
        - Programa encerra

        ----------------------------------------------------------------------
        -> Se não for tratado, a Exception sobe até a JVM e encerra o programa
         */

        methodOne();
    }

    public static void methodOne() {
        methodTwo();
    }

    public static void methodTwo() {
        int x = 10 / 0;
    }
}
