package com.leonardobarbosa.javastudy.exceptions.flow;

public class HandledExceptionFlow {
    public static void main(String[] args) {

        /*
        Demonstrar o uso de try/catch

        Ao tratar exception:
        - o erro deixa de interromper a aplicação
        - é possível executar ações de recuperação
        - o fluxo continua após o bloco do catch
         */

        System.out.println("Início...");

        try {
            method();
        } catch (ArithmeticException e) {
            System.out.println("Erro capturado pelo catch: " + e.getMessage());
        }

        System.out.println("Fim...");
    }

    public static void method() {
        int x = 10 / 0;
    }
}
