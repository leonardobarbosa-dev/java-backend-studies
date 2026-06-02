package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class UncheckedExceptionBasic {
    public static void main(String[] args) {

        /*
        UncheckedException (RuntimeException)

        - não precisam ser tratadas obrigatoriamente
        - não precisam ser declaradas com throws
        - normalmente indicam erros de programação

        Se não forem tratadas, a aplicação encerra
         */

        System.out.println("Início...");

        int x = 10 / 0;

        System.out.println("Fim...");

        /*
        Unchecked Exceptions (RuntimeExceptions)

        - tratamento e declaração com throws opcional
        - normalmente indicam erros de programação
        - detectadas em tempo de execução

        Exemplos comuns:
        -NullPointerException
        - ArithmeticException
        - ArrayIndexOutOfBoundException
        - IllegalArgumentException
         */
    }
}
