package com.leonardobarbosa.javastudy.exceptions.flow;

public class HandledExceptionFlow {
    public static void main(String[] args) {

        /*
        Objetivo: Introduzir try/catch

        -----------------------------------------------------------
        -> Se tratar a Exception, o fluxo continua
         */

        System.out.println("Início...");

        try {
            method();
        } catch (ArithmeticException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }

        System.out.println("Fim...");
    }

    public static void method() {
        int x = 10 / 0;
    }
}
