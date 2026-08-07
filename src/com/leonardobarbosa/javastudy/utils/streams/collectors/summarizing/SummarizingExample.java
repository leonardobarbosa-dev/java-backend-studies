package com.leonardobarbosa.javastudy.utils.streams.collectors.summarizing;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

class Manga {
    private final String name;
    private final double price;

    public Manga(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

public class SummarizingExample {
    public static void main(String[] args) {

        /*
        Collectors de resumo estatístico -> geram um único valor
        a partir de todos os elementos da stream

        counting()             -> quantidade de elementos
        summingDouble()        -> soma dos valores
        averagingDouble()      -> média dos valores
        summarizingDouble()    -> resumo completo (min, max, média, soma, count) de uma vez
         */

        List<Manga> mangas = List.of(
                new Manga("Death Note", 25.90),
                new Manga("Naruto", 27.90),
                new Manga("Pokemon", 17.90)
        );

        long count = mangas.stream()
                .collect(Collectors.counting());
        System.out.println("counting()        -> " + count);

        double sum = mangas.stream()
                .collect(Collectors.summingDouble(Manga::getPrice));
        System.out.println("summingDouble()    -> " + sum);

        double average = mangas.stream()
                .collect(Collectors.averagingDouble(Manga::getPrice));
        System.out.println("averagingDouble()  -> " + average);

        System.out.println("\n---\n");

        // summarizingDouble() -> min, max, count, sum e average, tudo de uma vez
        DoubleSummaryStatistics stats = mangas.stream()
                .collect(Collectors.summarizingDouble(Manga::getPrice));

        System.out.println("Tudo de uma vez -> " + stats);
        System.out.println("min     -> " + stats.getMin());
        System.out.println("max     -> " + stats.getMax());
        System.out.println("count   -> " + stats.getCount());
        System.out.println("sum     -> " + stats.getSum());
        System.out.println("average -> " + stats.getAverage());
    }
}