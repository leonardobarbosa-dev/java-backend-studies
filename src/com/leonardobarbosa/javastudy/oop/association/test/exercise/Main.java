package com.leonardobarbosa.javastudy.oop.association.test.exercise;

import com.leonardobarbosa.javastudy.oop.association.domain.exercise.Location;
import com.leonardobarbosa.javastudy.oop.association.domain.exercise.Seminar;
import com.leonardobarbosa.javastudy.oop.association.domain.exercise.Student;
import com.leonardobarbosa.javastudy.oop.association.domain.exercise.Teacher;

public class Main {
    public static void main(String[] args) {

        /*
        Crie um sistema que gerencie seminários
        O sistema deverá cadastrar seminários, estudantes, professores e local onde será realizado.

        Um aluno poderá estar em apenas um seminário
        Um seminário poderá ter nenhum ou vários alunos
        Um professor poderá ministrar vários seminários
        Um seminário deve ter um local

        Campos básicos (excluindo relacionamento)
        Seminário: título
        Aluno: nome, idade
        Professor: nome, especialidade
        Local: endereço
         */

        Location location = new Location("Universidade da California");

        Teacher teacher = new Teacher("Gustavo Guanabara", "Pai da programação");

        Seminar java = new Seminar("Java one for all", location);    // seminário tem um local
        Seminar python = new Seminar("Python", location);

        Student john = new Student("John", 24);
        Student jane = new Student("Jane", 29);
        /*
        Isso serve apenas de didática, quem manda é .setStudent(Students[])
         */

        Student[] students = {john, jane};  // relacionamento principal
        java.setStudent(students);  // um seminário pode possuir vários estudantes

        java.setTeacher(teacher);
        python.setTeacher(teacher);

        Seminar[] seminars = {java, python};
        teacher.setSeminar(seminars);   // um professor pode ministrar vários seminários

        java.print();
        python.print();
        jane.setSeminar(python);   // um estudante pode participar de apenas um seminário
    }
}
