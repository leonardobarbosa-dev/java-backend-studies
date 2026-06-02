package com.leonardobarbosa.javastudy.oop.methods.test;


import com.leonardobarbosa.javastudy.oop.methods.domain.VoidMethods;

public class VoidMethodsExample {
    public static void main(String[] args) {

        VoidMethods calculator = new VoidMethods();

        calculator.sum();      // sem parâmetros

        calculator.sumTwoNumbers(10, 30);  // passando dois parâmetro
        calculator.division(10,2);
    }
}
