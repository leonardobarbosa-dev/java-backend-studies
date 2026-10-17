package com.leonardobarbosa.javastudy.oop.polymorphism.domain;

public abstract class Product implements ProductTax {

    protected String name;
    protected double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getAdditionalInfo() {
        return "";
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
