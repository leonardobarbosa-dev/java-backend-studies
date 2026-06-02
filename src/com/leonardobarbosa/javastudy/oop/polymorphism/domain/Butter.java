package com.leonardobarbosa.javastudy.oop.polymorphism.domain;

public class Butter extends Product {

    private final String expirationDate;

    public Butter(String name, double value, String expirationDate) {
        super(name, value);
        this.expirationDate = expirationDate;
    }

    @Override
    public double calculateTax() {
        return this.value * 0.2;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String getAdditionalInfo() {
        return "Validade: " + this.expirationDate;
    }
}
