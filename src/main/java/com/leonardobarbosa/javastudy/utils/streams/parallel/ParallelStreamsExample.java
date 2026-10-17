package com.leonardobarbosa.javastudy.utils.streams.parallel;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamsExample {
    public static void main(String[] args) {

        /*
        parallelStream() -> divide o processamento entre várias threads
        (usa o ForkJoinPool comum da JVM por baixo dos panos)

        Vantagem -> pode ser mais rápido em volumes grandes de dados
        Cuidados:
        - ordem de execução não é garantida (forEach pode imprimir fora de ordem)
        - operações precisam ser independentes entre si (sem estado compartilhado)
        - para poucos elementos, o overhead de criar threads pode ser pior que sequencial
         */

        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();

        System.out.println("Sequential:");
        numbers.stream()
                .forEach(n -> System.out.println(Thread.currentThread().getName() + " -> " + n));

        System.out.println("-------");

        System.out.println("Parallel:");
        numbers.parallelStream()
                .forEach(n -> System.out.println(Thread.currentThread().getName() + " -> " + n));


        System.out.println("-------");
        /*
        Operações terminais como reduce(), sum(), collect() continuam
        corretas em paralelo, pois o resultado final é combinado ao fim
         */

        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("sum parallel -> " + sum);
    }
}
