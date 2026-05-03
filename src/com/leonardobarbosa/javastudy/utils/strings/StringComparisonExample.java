package com.leonardobarbosa.javastudy.utils.strings;

import java.util.Arrays;

public class StringComparisonExample {
    public static void main(String[] args) {

        // compareTo() -> comparação lexicográfica (útil para ordenação)

        // compareTo() -> retorna 0 se igual, negativo se menor, positivo se maior
        // Útil para ordenar strings manualmente
        System.out.println("abc".compareTo("abc")); // 0
        System.out.println("abc".compareTo("abd")); // -1 ('c' vem antes de 'd')
        System.out.println("b".compareTo("a"));     // 1  ('b' vem depois de 'a')

        // Ordenando um array de strings com compareTo internamente
        String[] listName = {"Carlos", "Ana", "Bruno"};
        Arrays.sort(listName);     // O metodo sort da classe java.util.Arrays organiza(ordena) o array em ordem natural.
        System.out.println(Arrays.toString(listName)); // [Ana, Bruno, Carlos]
    }
}
