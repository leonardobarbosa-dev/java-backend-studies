package com.leonardobarbosa.javastudy.exceptions.flow;

public class CallStackExceptionFlow {
    public static void main(String[] args) {

        /*
        Entender o funcionamento e ordem da call stack:

        Ordem da chamada:
        main() -> methodThree() -> methodTwo() -> methodOne()

        Quando ocorre uma exception, o stack trace mostra
        o caminho percorrido até o ponto onde o erro aconteceu
         */

        methodThree();
    }

    public static void methodThree() {
        methodTwo();
    }

    public static void methodTwo() {
        methodOne();
    }

    public static void methodOne() {
        int x = 10 / 0;
    }
}