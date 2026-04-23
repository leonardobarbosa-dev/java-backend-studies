package com.leonardobarbosa.javastudy.exceptions.flow;

public class CallStackExceptionFlow {
    public static void main(String[] args) {

        /*
        Objetivo: Entender a ordem da stack
        stack trace (de baixo para cima)
        - methodThree <onde ocorreu> -> methodTwo -> methodOne -> main

        --------------------------------------------------
        -> stack trace mostra o caminho do erro da origem até o topo
         */

        methodOne();
    }

    public static void methodOne() {
        methodTwo();
    }

    public static void methodTwo() {
        methodThree();
    }

    public static void methodThree() {
        int x = 10 / 0;
    }
}