package com.leonardobarbosa.javastudy.oop.association.domain;

public class Teacher {

    /*
    Associação bidirecional:
    O professor conhece o seminário
    e o seminário possui estudantes
     */

    private String name;
    private Seminar seminar;

    public Teacher(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Professor: " + this.name);
        if (seminar != null) {
            seminar.print();
        }
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }


}
