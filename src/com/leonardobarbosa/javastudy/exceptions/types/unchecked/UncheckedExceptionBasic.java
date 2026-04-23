package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class UncheckedExceptionBasic {
    public static void main(String[] args) {

        /*
        UncheckedException -> Não há obrigação de tratamento, try/catch - O programa encerra
         */
        System.out.println("Início...");

        int x = 10 / 0;

        System.out.println("Fim...");
    }
}
