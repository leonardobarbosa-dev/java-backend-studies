package com.leonardobarbosa.javastudy.oop.methods.domain;

public class ArrayHandling {

    /*
    É preciso criar o array antes e colocar a variavel dentro do metodo
    - sintaxe do array padrao: int[] <nome>
     */

    public void sumArray(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("\nSoma do array: ");
        System.out.println(sum);
    }


    /*
    O array é criado dentro do metodo, basta colocar os valores
    - sintaxe do VarArgs: int... <nome>     -> (Uma forma mais clean)
     */

    public void sumVarArgs(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("\nSoma do arrayVarArgs: ");
        System.out.println(sum);
    }



    // Exercício: -> pedir salários com VarArgs e calcular média

    public String name;
    public int age;

    public void calculateAverageSalary(double... salaries) {
        System.out.printf("\nNome do funcionário: %s | Idade: %d\n", this.name, this.age);

        double sum = 0;
        for(int i = 0; i < salaries.length; i++) {
            System.out.println((i+1) + "º salário: " + salaries[i]);
            sum += salaries[i];
        }

        double average = sum / salaries.length;
        System.out.printf("Média salarial: R$ %,.2f", average);
    }

}
