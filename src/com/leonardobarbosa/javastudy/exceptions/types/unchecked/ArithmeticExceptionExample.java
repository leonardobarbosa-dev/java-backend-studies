package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {

        /*
        ArithmeticException -> Operações inválidas (divisão por zero)
        - erro matemático simples
         */
        int x = 10 / 0;
        System.out.println(x);
    }
}
