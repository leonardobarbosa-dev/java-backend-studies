package com.leonardobarbosa.javastudy.oop.staticmodifier.domain;

public class StaticModifier {

    private final String make;
    private final int maxSpeed;

    /*
    Ao usar static em um atributo, ele deixa de pertencer ao objeto
    e passa a pertencer à classe.

    -Isso significa que o valor será compartilhado entre todas as instâncias criadas.
     */
    private static int speedLimit = 250;


    // Construtor
    public StaticModifier(String make, int maxSpeed) {
        this.make = make;
        this.maxSpeed = maxSpeed;
    }

    //
    public void printCar() {
        System.out.println("---------------");
        System.out.println("Marca: " + this.make);
        System.out.println("Velocidade Maxima: " + this.maxSpeed);

        System.out.println("Velocidade Limite: " + speedLimit); // // Não usar this. porque atributos static pertencem à classe
    }

    public static int getSpeedLimit() {
        return StaticModifier.speedLimit;
    }

    public static void setSpeedLimit(int speedLimit) {
        StaticModifier.speedLimit = speedLimit; // Por ser static, o valor deve ser acessado pela classe
    }
}
