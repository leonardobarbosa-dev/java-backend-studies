package com.leonardobarbosa.javastudy.fundamentals.loops;

import java.util.Scanner;

public class ForLoopExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        - for -> Usa índices (int index = 0; index < 10; index++)
         */

        // Exemplo básico do for
        System.out.println("\nContador for: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }


        // break:
        System.out.println("\nUso do break");
        int maxValue = 50;
        for (int i = 0; i <= maxValue; i++) {
            if(i > 25) {
                break;  // Contador para no 25 mesmo valor máximo sendo 50
            }
            System.out.print(i + " ");
        }


        // continue
        System.out.println("\nExemplo com continue:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;   // pula apenas esta iteração (1, 2, 3, 4, 6, 7, 8, 9, 10)
            }
            System.out.print(i + " ");
        }

        sc.close();
    }
}
