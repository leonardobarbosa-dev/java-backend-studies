package com.leonardobarbosa.javastudy.fundamentals.conditionals;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Exercício
        System.out.println("\nCalcular parcelas de financiamento:");

        System.out.print("\nDigite o valor do carro:");
        double carValue = scanner.nextDouble();
        scanner.nextLine();

        for (int installments = 1; installments <= carValue; installments++) {
            double installmentsValue = carValue / installments;
            if(installmentsValue >= 1000) {
                System.out.println("\nDentro do if: ");
                System.out.printf("Valor total do carro: %,.2f\n%d parcelas de %,.2f\n",
                        carValue, installments, installmentsValue);
            } else {
                break; // o break impede que fora do if (parcelas) continue contando até o valor do carro
            }
            System.out.println("Parcelas(fora do if): " + installments);
        }
    }
}
