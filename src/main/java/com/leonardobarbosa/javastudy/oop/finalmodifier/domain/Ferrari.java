package com.leonardobarbosa.javastudy.oop.finalmodifier.domain;

public final class Ferrari extends Car {

    /*
    Classe final não pode ser estendida
    Nenhuma outra clase pode herdar ela
     */

    public Ferrari(String name, int maxSpeed) {
        super(name, maxSpeed);
    }

    public void messageFerrari() {
        System.out.println("|||Viva a aventura de uma ferrari|||");
    }

}
