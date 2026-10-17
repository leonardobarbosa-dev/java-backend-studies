package com.leonardobarbosa.javastudy.utils.serialization.domain;

public class StudentClass {

    private String name;

    public StudentClass() {
    }

    public StudentClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
