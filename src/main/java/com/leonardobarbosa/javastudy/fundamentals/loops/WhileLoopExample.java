package com.leonardobarbosa.javastudy.fundamentals.loops;

public class WhileLoopExample {
    public static void main(String[] args) {

        /*
         - while -> só executa ser for true
         - do while -> executa ao menos uma vez independente da condição ser true ou false
         */

        // while:
        int count = 0;
        System.out.println("\nContador while: ");

        while(count <= 10){
            System.out.println(count);
            count++;
        }

        // do while:
        System.out.println("\nContador do while: ");

        do {
            System.out.println(count);  // executa o bloco pelo menos uma vez e a condição é verificada no final
            count++;
        } while (count <= 10);  // count = 11 (false)

    }
}
