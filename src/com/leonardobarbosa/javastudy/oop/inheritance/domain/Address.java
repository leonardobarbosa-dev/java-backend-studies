package com.leonardobarbosa.javastudy.oop.inheritance.domain;

public class Address {

    private final String street;
    private final String zipCode;

    public void print() {
        System.out.println("Rua: " + this.street + " Cep: " + this.zipCode);
    }

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}
