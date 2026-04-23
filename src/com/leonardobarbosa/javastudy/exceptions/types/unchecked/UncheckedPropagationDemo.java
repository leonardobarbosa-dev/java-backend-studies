package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class UncheckedPropagationDemo {
    public static void main(String[] args) {

        /*
        Objetivo: Mostrar a propagação sem obrigação de tratar

        ----------------------------------------------------------------------
        UncheckedExceptions = RuntimeException -> Representam erros de programação (código)
        - Não obrigatório tratar
        - Geralmente erro no código
        - Sobe livre na stack
         */
        methodOne();
    }

    public static void methodOne() {
        methodTwo();
    }

    public static void methodTwo() {
        String text = null;
        text.length();
    }
}
