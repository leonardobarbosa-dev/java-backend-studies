package com.leonardobarbosa.javastudy.exceptions.flow;

public class UnhandledExceptionExample {
    public static void main(String[] args) {

        /*
        Objetivo: Ver o fluxo sendo interrompido

        --------------------------------------------------
        -> Exception interrompe o fluxo imediatamente
         */

        System.out.println("Início...");
        methodOne();
        System.out.println("Fim..."); //Não executa
    }

    public static void methodOne() {
        int x = 10 / 0;
    }
}
