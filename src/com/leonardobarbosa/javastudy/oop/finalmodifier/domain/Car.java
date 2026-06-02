package com.leonardobarbosa.javastudy.oop.finalmodifier.domain;

public class Car {

    private String name;
    private final int maxSpeed;

    private static final int SPEED_LIMIT = 150;
    /*
    final impede que o valor seja alterado após a inicialização

    static final geralmente é usado para constantes,
    pois existe apenas uma cópia compartilhada por toda a classe.

    Constantes Java seguem a convenção: UPPER_CASE_WITH_UNDERSCORE
     */

    public final Purchaser purchaser = new Purchaser();
    /*
    modificador final com objetos
    bmw.purchaser.setName(); = está alterando o conteúo da casa e não a referência do objeto
    -------------------------------------------------------------------------------------------
    Em Java, o modificador final em tipos de referência impede que
    a variável aponte para outro objeto após a inicialização,
    mas não impede a modificação do estado interno do objeto referenciado.
    -------------------------------------------------------------------------------------------
    Cada objeto possui sua própria referência, que não pode ser alterada
    para apontar para outro objeto, mas o conteúdo do objeto pode ser modificado.
     */

    @Override
    public String toString() {
        return String.format("Carro: %s | Velocidade maxima: %d | Velocidade limite da via: %d",
                this.name, this.maxSpeed, Car.SPEED_LIMIT);
    }

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
