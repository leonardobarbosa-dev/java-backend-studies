package com.leonardobarbosa.javastudy.oop.methods.domain;

public class OutputMethods {

    public String name = "Goku";
    public int age = 45;
    public char sex = 'M';

    public void print() {
        System.out.println("\n" + this.name);
        System.out.println(this.age);
        System.out.println(this.sex);
    }


    public void printPerson(OutputMethods person) {
        System.out.printf("\nEstudante: %s - Idade: %d - Sexo: %c"
                ,  person.name, person.age, person.sex);
    }

    /*
    O metodo printStudent passa uma parâmetro do tipo referencia as variáveis
    (name, age e sex) vão ser do objeto especifico que for passado (girl or boy)
     */
}
