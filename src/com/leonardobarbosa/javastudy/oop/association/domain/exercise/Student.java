package com.leonardobarbosa.javastudy.oop.association.domain.exercise;

public class Student {

    private final String name;
    private final int age;

    private Seminar seminar;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        if (seminar != null) {
            System.out.println("O aluno " + this.name + " já está cadastrado em um seminário");
            return;
        }
        this.seminar = seminar;
    }
}