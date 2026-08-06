package com.leonardobarbosa.javastudy.utils.streams.generating;

import java.util.List;
import java.util.stream.Stream;

public class GeneratingStreamsExample {
    public static void main(String[] args) {

        /*
        Streams também podem ser criadas sem uma coleção existente

        Stream.of()      -> cria a partir de elementos avulsos
        Stream.iterate()  -> gera elementos aplicando uma função repetidamente
        Stream.generate() -> gera elementos infinitamente a partir de um Supplier
        - iterate() e generate() são infinitas -> precisam de limit()
         */

        // Stream.of() -> a partir de valores diretos
        Stream.of("Naruto", "Death Note", "Pokemon")
                .forEach(System.out::println);

        System.out.println("\n---\n");

        // Stream.iterate() -> começa em 1, dobra a cada passo, limitado a 5 elementos
        List<Integer> powersOfTwo = Stream.iterate(1, n -> n * 2)
                .limit(5)
                .toList();
        System.out.println("iterate() -> " + powersOfTwo);

        // iterate() com condição de parada -> substitui o limit()
        List<Integer> until100 = Stream.iterate(1, n -> n < 100, n -> n * 2)
                .toList();
        System.out.println("iterate() com condição -> " + until100);

        // Stream.generate() -> repete o mesmo Supplier indefinidamente
        Stream.generate(() -> "Java")
                .limit(3)
                .forEach(System.out::println);


    }
}
