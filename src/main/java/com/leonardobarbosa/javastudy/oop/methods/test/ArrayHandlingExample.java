package com.leonardobarbosa.javastudy.oop.methods.test;

import com.leonardobarbosa.javastudy.oop.methods.domain.ArrayHandling;

public class ArrayHandlingExample {
    public static void main(String[] args) {

        ArrayHandling calculator = new ArrayHandling();

        // Valores atribuídos no array
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        calculator.sumArray(numbers);

        // VarArgs -> os valores são colocados dentro do array
        calculator.sumVarArgs(1,2,3,4,5);


        // Exercício:
        ArrayHandling worker = new ArrayHandling();

        worker.name = "Light Yagami";
        worker.age = 19;

        worker.calculateAverageSalary(2459, 2577, 2899);

    }
}
