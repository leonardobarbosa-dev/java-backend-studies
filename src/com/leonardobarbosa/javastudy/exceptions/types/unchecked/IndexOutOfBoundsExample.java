package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

import java.util.Arrays;

public class IndexOutOfBoundsExample {
    public static void main(String[] args) {

        /*
        IndexOutOfBoundsExceptions -> Acessar posição inválida gera erro de índice
        - erro de acesso inválido (índice inexistente)
         */
        int numbers[] = { 1, 2, 3, 4, 5 };
        System.out.println(numbers[6]);
    }
}
