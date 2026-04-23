package com.leonardobarbosa.javastudy.oop.methods.test;

import com.leonardobarbosa.javastudy.oop.methods.domain.OutputMethods;

public class OutputMethodsExample {
    public static void main(String[] args) {

        OutputMethods girl = new OutputMethods();
        girl.name = "Sakura";
        girl.age = 19;
        girl.sex = 'F';
        girl.print();


        OutputMethods boy = new OutputMethods();
        boy.name = "Kakashi";
        boy.age = 37;
        boy.sex = 'M';
        boy.print();


        OutputMethods printer  = new OutputMethods();
        printer.printStudent(girl);
        printer.printStudent(boy);

    }
}
