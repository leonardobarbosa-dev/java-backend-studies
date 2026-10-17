package com.leonardobarbosa.javastudy.oop.abstraction.domain;

public class Manager extends Worker {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.1;
    }
}
