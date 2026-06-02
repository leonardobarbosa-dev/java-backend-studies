package com.leonardobarbosa.javastudy.oop.inheritance.domain;

public class Worker extends Person {

    private final double salary;

    public Worker(String name, String cpf, Address address, double salary) {
        super(name, cpf, address);
        this.salary = salary;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("Salário: %.3f%n", this.salary);
//        System.out.println(this.name);    -> protected = permite acesso às subclasses
    }
}
