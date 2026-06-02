package com.leonardobarbosa.javastudy.fundamentals.arrays;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {

        /*
        Array é uma estrutura que armazena múltiplos valores do mesmo tipo
        - Possui tamanho fixo
        - Os índices começam em [0]
        - Todos os elementos possuem valor padrão

        Quando um array é criado, seus elementos recebem automaticamente valores padrão

        Tipos primitivos:
        - byte, short, int, long    -> 0
        - float, double             -> 0.0
        - char                      -> '\u0000' (char null)
        - boolean                   -> false

        Tipos referência:
        - String, objetos, etc      -> null
         */

        // Criando array com tamanho fixo e adicionando valores
        int[] ages = new int[5];    // [0] [1] [2] [3] [4]  -> posições não preenchidas continuam com valor padrão
        ages[0] = 18;
        ages[1] = 21;
        ages[2] = 36;

        // Percorrendo array com for tradicional
        System.out.println("\nfor tradicional:");
        for(int i = 0; i < ages.length; i++) {  // .lenght retorna o tamanho do array
            System.out.println("Índice: " + i + " = " + ages[i]);
        }

        // Percorrendo array com for-each
        System.out.println("\nfor-each:");

        /*
        Sintaxe:
            for (<tipo> <variável> : <array>

            - o for-each percorre elemento por elemento. Não fornece o índice diretamente.
         */

        for(int age : ages) {
            System.out.println(age);
        }

        // Outras formas de inicializar arrays (as chaves {} determinam o tamanho base)

        int[] numbers = {10, 20, 30};   // simplificada
        // -> usar quando for declarar e inicializar (criar e atribuir valores)

        int[] values = new int[]{11, 22, 33};   // explícita
        //-> usar quando precisar criar o array fora da declaração (exemplo: ages) ou passar diretamente como argumento


        // Exibir o array completo
        System.out.println("\nArray completo:");
        System.out.println(Arrays.toString(numbers));

        /*
       Arrays.toString()    -> converte o array para uma String
         */
    }
}
