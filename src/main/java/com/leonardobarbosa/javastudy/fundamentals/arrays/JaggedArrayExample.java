package com.leonardobarbosa.javastudy.fundamentals.arrays;

public class JaggedArrayExample {
    public static void main(String[] args) {

        /*
        Array irregular (jagged array)
        - Array multidimensional é um "array de arrays"
        - a primeira dimensão representa as linhas e a segunda as colunas
        - Isso significa que cada linha pode possuir tamanhos diferentes (jagged array)
         */

        // Criando array principal
        int[][] numbers = new int[3][];

        // Criando arrays internos -> cada posição recebe um array diferente
        numbers[0] = new int[] {1, 2, 3};
        numbers[1] = new int[] {10, 20};
        numbers[2] = new int[] {100, 200, 300, 400};

        /*
        Estrutura final:

        numbers
        │
        ├── [0] -> [1, 2, 3]
        ├── [1] -> [10, 20]
        └── [2] -> [100, 200, 300, 400]
         */

        // Percorrendo o array
        System.out.println("For-each:");
        for (int[] row : numbers) {     // primeiro for -> percorre cada linha [0], [1], [2]
            for (int value : row) {    // segundo for -> percorre cada valor da linha atual [0] -> {1, 2, 3}
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();

        /*
        Usar o for tradicional quando precisar:
        - dos índices
        - acessar posições específicas
        - comparar linhas colunas
         */
        System.out.println("For tradicional:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Linha: " + i);
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(" Valor: " + numbers[i][j]);
            }
            System.out.println();
        }
        System.out.println();


        // Exemplo prático
        int[][] monthDays = new int[2][];   // Cada mês possui quantidade diferente de dias
        monthDays[0] = new int[31]; // janeiro
        monthDays[1] = new int[28]; // fevereiro

        System.out.println("Dias por mês:");

        for(int i = 0; i < monthDays.length; i++) {
            System.out.println("Mês: " + (i+1) + " -> " + monthDays[i].length + " dias");
        }

        /*
        Na proxima classe (MultidimensionalArrayExample) o foco será
        entender melhor estruturas multidimensionais
         */
    }
}
