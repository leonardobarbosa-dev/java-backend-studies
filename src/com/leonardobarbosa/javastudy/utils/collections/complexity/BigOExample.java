package com.leonardobarbosa.javastudy.utils.collections.complexity;

public class BigOExample {
    public static void main(String[] args) {

        /*
        Big-O -> mede como o tempo (ou memória) de um algoritmo cresce
        conforme o tamanho da entrada (n) aumenta

        - Ele é a ferramenta que descreve quão rápido um algoritmo
        ou operação fica mais lento conforme os dados crescem.

        - Não é tempo real em milissegundos, é uma forma de comparar
        eficiência entre algoritmos

        Principais complexidades, da mais rápida pra mais lenta:
        O(1) < O(log n) < O(n) < O(n log n) < O(n²)

        O(1)
        - constante
        - não depende do tamanho da entrada


        O(log n)
        - cresce lentamente
        - normalmente divide o problema pela metade


        O(n)
        - linear
        - percorre todos os elementos


        O(n log n)
        - comum em algoritmos eficientes de ordenação


        O(n²)
        - quadrática
        - geralmente dois loops aninhados
         */

        int[] numbers = new int[10_000];
        warmUp(numbers);


        // O(1)
        long start = System.nanoTime();

        int value = numbers[0]; // acessa posição específica -> 1 operação

        long end = System.nanoTime();

        System.out.println("O(1): " + (end - start) + " ns");


        // O(n)
        start = System.nanoTime();

        long sum = 0;
        for (int number : numbers) {    // acessa cada posição uma vez -> 100.000 operações
            sum += number;
        }

        end = System.nanoTime();
        System.out.println("O(n): " + (end - start) + " ns");


        // O(n²)
        start = System.nanoTime();

        long sumQuadratic = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                sumQuadratic += numbers[i] + numbers[j];
            }
        }
        /*
        Na primeira volta i = 0
        j percorre: numbers[0] + numbers[0] -> [1] -> [2]   -> 100.000 vezes
        depois i = 1    -> tudo novamente

        Então   -> 100.000 x 100.000 = 10.000.000.000 (10 bilhões de operações)
         */
        end = System.nanoTime();
        System.out.println("O(n²): " + timeMs(start, end) + " ms");



    }

    // Operações muito rápidas podem retornar 0ms
    // Para maior precisão, usar nanosegundos
    private static long timeMs(long start, long end) {
        return (end - start) / 1_000_000;
    }

        /*
        Medição:

        System.nanoTime()
        - mede duração da execução

        Conversão:
        1 ms = 1_000_000 ns

        O tempo real depende de:
        - hardware  - JVM   - quantidade de dados

        Big-O analisa crescimento conforme n aumenta.
         */

        // aquecimento da JVM -> a primeira execução inclui custos de carregamento, otimização, etc.
        private static void warmUp(int[] numbers) {

            long sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            System.out.println("warm up finished");
        }
}