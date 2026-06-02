package com.leonardobarbosa.javastudy.oop.association.domain;

public class Seminar {

    private String title;
    private Student[] students;

    public Seminar(String title, Student[] students) {
        this.title = title;
        this.students = students;
    }

    public void print() {
        System.out.println("Seminário: " + title);
        if (students == null) {
            System.out.println("Nenhum aluno encontrado");
            return; // interrompe a execução do metodo (tudo que vem a seguir)
        }
        System.out.println("Estudantes:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
