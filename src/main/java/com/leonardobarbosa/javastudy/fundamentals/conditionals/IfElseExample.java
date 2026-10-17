package com.leonardobarbosa.javastudy.fundamentals.conditionals;

import java.util.Scanner;

public class IfElseExample {
    public static void main(String[] args) {

//        if - elseif - else
        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular porcentagem de impostos");
        System.out.print("Digite seu salário: ");
        double salary = sc.nextDouble();

        double taxOne = 0.10;
        double taxTwo = 0.20;
        double taxThree = 0.35;
        double taxFour = 0.45;
        double tax;

        if (salary > 0 && salary <= 5000) {
            tax = salary * taxOne;
        } else if (salary <= 15000) {
            tax = salary * taxTwo;
        } else if (salary <= 50000) {
            tax = salary * taxThree;
        } else {
            tax = salary * taxFour;
        }

        double finalSalary = salary - tax;
        
        System.out.printf("Sálario bruto : %,.2f - Impostos: %,.2f - Salário liquido: %,.2f\n"
                , salary, tax, finalSalary);

        // Exemplo com boolean
        System.out.println("\nPermissão para comprar bebida alcoólica:");
        int age = 19;
        boolean isAuthorized = age >= 18;
        boolean isAccompanied = false;

        if (isAuthorized) {
            System.out.println("Autorizado a comprar bebida alcoólica");
        } else if (isAccompanied) {
            System.out.println("Autorizado a comprar bebida acompanhado de maior de idade");
        } else {
            System.out.println("Não tem idade suficiente parra comprar bebida alcoólica");
        }

        /*
         Operador ternário

         - USAR -> (condição) ? (se) verdadeiro : (senao) falso
         - NÃO USAR -> (condicao) ? (se) verdadeiro : (senao se) (condicao) ? (se) verdadeiro : (senao) falso
           Fica muito difícil de ler, mas é possível, usar apenas a opção (? IF : ELSE)
         */

        System.out.println("\nDoar para a ONG:");
        double money = 5000;
        String donateMessage = "Doar 500 reais para a ONG!";
        String doNotDonateMessage = "Não tenho condições de doar para a ONG, Mas vou ter!";
        String result;
//        result = money > 4000 ? donateMessage : doNotDonateMessage;
//        System.out.println(result);
        System.out.println(result = money > 4000 ? donateMessage : doNotDonateMessage); // Uso diretamente no print

        sc.close();
    }
}
