package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {

        /*
        ArithmeticException

        Ocorre quando uma operação matemática
        inválida é executada.

        Exemplo:
        - divisão inteira por zero
         */

        int x = 10 / 0;
        System.out.println(x);
    }
}
