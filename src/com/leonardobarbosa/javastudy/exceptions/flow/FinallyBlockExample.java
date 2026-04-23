package com.leonardobarbosa.javastudy.exceptions.flow;

public class FinallyBlockExample {
    public static void main(String[] args) {

        /*
        Objetivo: Entender o uso do finally

        ----------------------------------------------------------------------
        -> Finally executa com ou sem erro (exceto falha crítica da JVM)
         */

        try {
            System.out.println("Tentando executar...");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Erro tratato: " + e.getMessage());
        } finally {
            System.out.println("Finally sempre executa...");
        }
    }
}
