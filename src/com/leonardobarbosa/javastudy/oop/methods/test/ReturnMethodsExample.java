package com.leonardobarbosa.javastudy.oop.methods.test;

import com.leonardobarbosa.javastudy.oop.methods.domain.ReturnMethods;

public class ReturnMethodsExample {
    public static void main(String[] args) {


        ReturnMethods calculator = new ReturnMethods();


        double result = calculator.subtraction(20000, 9000);
        System.out.println("\nResultado: " + result);

        // Chamando diretamente no print com resultado formatado
        System.out.printf("\nDentro do print: %.2f", calculator.subtraction(100, 75));

    }
}
