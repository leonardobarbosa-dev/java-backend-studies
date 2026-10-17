package com.leonardobarbosa.javastudy.oop.polymorphism.domain;

public class Laptop extends Product {

    private final String warranty;

    public Laptop(String name, double value, String warranty) {
        super(name, value);
        this.warranty = warranty;
    }

    @Override
    public double calculateTax() {
        return this.value * 0.5;
    }

    @Override
    public String getAdditionalInfo() {
        return "Garantia: " +  this.warranty;
    }
}
