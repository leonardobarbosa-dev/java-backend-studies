package com.leonardobarbosa.javastudy.oop.association.test;

import com.leonardobarbosa.javastudy.oop.association.domain.Seminar;
import com.leonardobarbosa.javastudy.oop.association.domain.Student;
import com.leonardobarbosa.javastudy.oop.association.domain.Teacher;

public class BidirectionalAssociationExample {
    public static void main(String[] args) {

        /*
        - Associação um para muitos
        um objeto pode possuir vários outros objetos
        Seminar -> Student[]

        - Associação muitos para um
        vários objetos podem referênciar o mesmo objeto
        vários jogadores -> mesmo time
         */

        Student john = new Student("John");
        Student jane = new Student("Jane");

        Student[] students = {john, jane};

        Seminar seminar = new Seminar("Seminário Java", students);

        Teacher teacher = new Teacher("Willian DevDojo");
        teacher.setSeminar(seminar);

        teacher.print();
    }
}
