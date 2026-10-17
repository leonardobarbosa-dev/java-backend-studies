package com.leonardobarbosa.javastudy.oop.association.domain.exercise;

public class Seminar {

    private final String title;
    private final Location location;

    private Teacher teacher;
    private Student[] student;

    public Seminar(String title, Location location) {
        this.title = title;
        this.location = location;
    }

    public void print() {
        System.out.println("\nSeminário: " + this.title);
        if (this.location != null) {
            System.out.println("Local: " + location.getAddress());
        }
        if (this.teacher != null) {
            System.out.println("Professor: " + teacher.getName());
        }
        if (this.student != null) {
            System.out.println("Alunos: ");
            for (Student student : student) {
                System.out.print("- " + student.getName() + " ");
            }
            System.out.println();
        }
    }

    public String getTitle() {
        return title;
    }

    public Location getLocation() {
        return location;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }
}