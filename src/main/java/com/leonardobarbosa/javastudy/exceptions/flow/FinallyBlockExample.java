package com.leonardobarbosa.javastudy.exceptions.flow;

public class FinallyBlockExample {
    public static void main(String[] args) {

        /*
        Demonstrar o bloco finally:

        O bloco finally é executado independentemente
        de ocorrer exception ou não.

        É normalmente utilizado para:
        - fechar arquivos
        - liberar conexões ou recursos

        Exceto em situações críticas na JVM,
        o finally sempre será executado.
         */

        try {
            System.out.println("Tentando executar...");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Erro capturado no catch: " + e.getMessage());
        } finally {
            System.out.println("Finally: sempre executa...");
        }
    }
}
