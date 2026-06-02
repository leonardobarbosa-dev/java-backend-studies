package com.leonardobarbosa.javastudy.oop.staticmodifier.test;

import com.leonardobarbosa.javastudy.oop.staticmodifier.domain.StaticModifier;

public class StaticModifierExample {
    public static void main(String[] args) {

        StaticModifier.setSpeedLimit(180);  // // O valor será compartilhado por todos os objetos da classe

        System.out.println("\nVelocidade limite da compartilhada: " + StaticModifier.getSpeedLimit());

        StaticModifier audi = new StaticModifier("Audi", 299);
        audi.printCar();

        StaticModifier bmw = new StaticModifier("BMW", 285);
        bmw.printCar();

        StaticModifier wv = new StaticModifier("WV", 289);
        wv.printCar();

        /*
        Existem três objetos e uma única variável static (speedLimit) compartilhada
         */
    }
}
