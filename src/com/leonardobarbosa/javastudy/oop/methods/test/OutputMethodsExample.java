package com.leonardobarbosa.javastudy.oop.methods.test;

import com.leonardobarbosa.javastudy.oop.methods.domain.OutputMethods;

public class OutputMethodsExample {
    public static void main(String[] args) {

        OutputMethods printer  = new OutputMethods();

        printer.print();    // Como nenhum objeto foi criado, retorna os valores padrão que estáo na classe

        OutputMethods girl = new OutputMethods();
        girl.name = "Sakura";
        girl.age = 19;
        girl.sex = 'F';

        printer.printPerson(girl);


        OutputMethods boy = new OutputMethods();
        boy.name = "Kakashi";
        boy.age = 37;
        boy.sex = 'M';

        printer.printPerson(boy);

    }
}
