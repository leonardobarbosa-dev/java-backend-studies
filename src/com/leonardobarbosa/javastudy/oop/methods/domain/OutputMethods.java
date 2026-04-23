package com.leonardobarbosa.javastudy.oop.methods.domain;

public class OutputMethods {

    public String name = "Goku";
    public int age;
    public char sex;

    public void print() {
        System.out.println("\n" + this.name);
        System.out.println(this.age);
        System.out.println(this.sex);
    }

    /*

    --------------------------------------------------------------------------------------

    O metodo printStudent passa uma parâmetro do tipo referencia
    (name, age and sex) vão ser do objeto especifico que for passado (girl or boy)
     */

    public void printStudent(OutputMethods student) {
        System.out.printf("\nEstudante: %s - Idade: %d - Sexo: %c"
                ,  student.name, student.age, student.sex);
    }

}
