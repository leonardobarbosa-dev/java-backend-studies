package com.leonardobarbosa.javastudy.oop.polymorphism.domain;

public class CellPhone extends Product {


    public CellPhone(String name, double value) {
        super(name, value);
    }

    @Override
    public double calculateTax() {
        return this.value * 0.6;
    }

}
