package com.leonardobarbosa.javastudy.utils.streams.collectors.groupingby;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Manga {
    private final String name;
    private final String genre;
    private final double price;

    public Manga(String name, String genre, double price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public String getName() { return name; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name;
    }
}

enum Promotion {
    UNDER_PROMOTION,
    NORMAL_PRICE
}

public class GroupingByExample {
    public static void main(String[] args) {

        /*
        groupingBy() -> agrupa os elementos da stream em um Map,
        usando o resultado de uma Function como chave

        groupingBy(classifier)                    -> Map<K, List<T>>, valor padrão é uma lista
        groupingBy(classifier, downstream)         -> Map<K, R>, downstream processa cada grupo
         */

        List<Manga> mangas = List.of(
                new Manga("Death Note", "Mystery", 25.90),
                new Manga("Naruto", "Action", 27.90),
                new Manga("Dragon Ball", "Action", 18.90),
                new Manga("Pokemon", "Adventure", 17.90)
        );

        // groupingBy classifier condicional -> Map<Promotion, List<Manga>>
        Map<Promotion, List<Manga>> byPromotion = mangas.stream()
                .collect(Collectors.groupingBy(manga -> manga.getPrice() < 20 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));
        System.out.println("Promotion -> " + byPromotion);

        // groupingBy simples -> Map<String genre, List<Manga>>
        Map<String, List<Manga>> byGenre = mangas.stream()
                .collect(Collectors.groupingBy(Manga::getGenre));
        System.out.println("byGenre -> " + byGenre);

        // groupingBy + counting() -> Map<String genre, Long amount>
        Map<String, Long> countByGenre = mangas.stream()
                .collect(Collectors.groupingBy(Manga::getGenre, Collectors.counting()));
        System.out.println("countByGenre ->" + countByGenre);

        // groupingBy + averagingDouble() -> Map<String genre, Double average>
        Map<String, Double> avgPriceByGenre = mangas.stream()
                .collect(Collectors.groupingBy(Manga::getGenre, Collectors.averagingDouble(Manga::getPrice)));
        System.out.println("avgPriceByGenre -> " + avgPriceByGenre);

        // groupingBy + mapping() -> Map<String genre, List<String> names>
        Map<String, List<String>> namesByGenre = mangas.stream()
                .collect(Collectors.groupingBy(Manga::getGenre, Collectors.mapping(Manga::getName, Collectors.toList())));
        System.out.println("namesByGenre -> " + namesByGenre);
    }
}
