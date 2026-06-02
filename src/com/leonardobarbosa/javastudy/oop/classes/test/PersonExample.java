package com.leonardobarbosa.javastudy.oop.classes.test;

import com.leonardobarbosa.javastudy.oop.classes.domain.Person;

public class PersonExample {
    public static void main(String[] args) {

        Person student = new Person();
        student.name = "João";
        student.age = 19;
        student.sex = 'M';
        student.job = "Trainee programmer";

        System.out.printf("\nNome: %s - Idade: %d - Sexo: %c - Profissão: %s"
        ,  student.name, student.age, student.sex,  student.job);
    }
}
