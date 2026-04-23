package com.leonardobarbosa.javastudy.oop.methods.test;

import com.leonardobarbosa.javastudy.oop.methods.domain.ArrayHandling;

public class ArrayHandlingExample {
    public static void main(String[] args) {

        ArrayHandling calculadora = new ArrayHandling();
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};
        calculadora.somaArray(numeros);

        /*
        ------------------------------------------------------------------------------
         */

        calculadora.somaVarArgs(1,2,3,4,5);

        /*
        ------------------------------------------------------------------------------
         */

        ArrayHandling funcionario = new ArrayHandling();

        funcionario.name = "Light Yagami";
        funcionario.age = 19;
        funcionario.printDev();
        funcionario.calculateAverageSalary(2459, 2577, 2899);

    }
}
