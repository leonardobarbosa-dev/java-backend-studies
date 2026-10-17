package com.leonardobarbosa.javastudy.oop.association.domain.exercise;

public class Teacher {

    private final String name;
    private final String expertise;

    private Seminar[] seminar;

    public Teacher(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public Seminar[] getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar[] seminar) {
        this.seminar = seminar;
    }
}