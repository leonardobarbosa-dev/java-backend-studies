package com.leonardobarbosa.javastudy.oop.abstraction.domain;

public class Developer extends Worker {

    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }
}
