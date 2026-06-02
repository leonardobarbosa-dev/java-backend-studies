package com.leonardobarbosa.javastudy.fundamentals.arrays;

import java.util.Arrays;

public class MultidimensionalArrayExample {
    public static void main(String[] args) {

        /*
        Em Java, arrays multidimensionais também podem possuir linhas com tamanhos diferentes.
        Quando isso acontece, chamamos de: Jagged Array (Array irregular)

        ----------------------------------------------------------------------------------------------
        Cada índice em students representa um aluno
        A mesma posição em scores representa as notas daquele aluno

        Estrutura:
            [linha] [coluna]

        students
        [0] = John
        [1] = Jane
        [2] = Julie

        scores
        [0] = John  { 10, 6, 8 }
        [1] = Jane  { 8, 9, 6 }
        [2] = Julie { 7, 8, 7 }
         */

        String[] students = {
                "John",
                "Jane",
                "Julie"
        };

        // Criando array multidimensional 3x3
        int[][] scores = {
                {10, 6, 8},
                {8, 9, 6},
                {7, 8, 7}
        };

        /*
        Diferente do JaggedArrayExample,
        todas as linhas possuem o mesmo tamanho neste exemplo.
         */

        // Acessando valores específicos
        System.out.println("Primeiro valor: " + scores[0][0]);
        System.out.println("Centro da matriz: " + scores[1][1]);
        System.out.println("Último valor: " + scores[2][2]);
        System.out.println();

        /*
        Percorrendo array com for-each
        - O for-each percorre os elementos diretamente, mas não fornece o índice.
        - Usar quando só precisar ler os elementos

        - Como não temos acesso ao índice, não conseguimos relacionar diretamente
        cada linha ao estudante correspondente
         */

        for (int[] row : scores) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();


        /*
        Percorrendo array com for tradicional
        - o for tradicional controla o índice manualmente, então mostra os estudantes e suas respectivas notas
         */

        for (int i = 0; i < students.length; i++) {
            System.out.print("Estudante: " + students[i] + " | Notas:");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(" [" + scores[i][j] + "] ");
            }
            System.out.println();
        }
    }
}