package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class UncheckedPropagationDemo {
    public static void main(String[] args) {

        /*
        Demonstrar a propagação de uma RuntimeException

        UncheckedExceptions = RuntimeException
        - não exigem tratamento obrigatório nem declaração com throws
        - normalmente indicam erros de programação
        - propagam-se livres pela call stack

        Se não forem tratadas, chegam a JVM
        e encerram a aplicação
         */

        methodTwo();
    }

    public static void methodTwo() {
        methodOne();
    }

    public static void methodOne() {
        String text = null;
        text.length();
    }
}
