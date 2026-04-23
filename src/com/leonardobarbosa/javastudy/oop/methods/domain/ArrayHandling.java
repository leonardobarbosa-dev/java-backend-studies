package com.leonardobarbosa.javastudy.oop.methods.domain;

public class ArrayHandling {

    /*
    É preciso criar o array antes e colocar a variavel dentro do metodo
    - sintaxe do array padrao = int[] numeros
     */
    public void somaArray(int[] numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        System.out.println("\nSoma do array: ");
        System.out.println(soma);
    }

    /*
    ---------------------------------------------------------------------------------------


    O array é criado dentro do metodo, basta colocar os valores
    - sintaxe do VarArgs = int... numeros | (Uma forma mais clean de fazer)
     */

    public void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        System.out.println("\nSoma do arrayVarArgs: ");
        System.out.println(soma);
    }


    /*
    --------------------------------------------------------------------------------------
     */

    public String name;
    public int age;

    public void printDev() {
        System.out.printf("\nNome do funcionário: %s | Idade: %d\n", this.name, this.age);
    }

    public void calculateAverageSalary(double... salarios) {
        double total = 0;
        for(int i = 0; i < salarios.length; i++) {
            System.out.println((i+1) + "º salário: " + salarios[i]);
            total += salarios[i];
        }
        double media = total / salarios.length;
        System.out.printf("\nMédia salarial do funcionário: %s | R$ %,.2f", this.name, media);
    }

}
