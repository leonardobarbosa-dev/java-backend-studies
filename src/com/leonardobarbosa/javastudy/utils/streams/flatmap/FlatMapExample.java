package com.leonardobarbosa.javastudy.utils.streams.flatmap;

import java.util.List;

class Manga {
    private final String name;
    private final List<String> genres;

    public Manga(String name, List<String> genres) {
        this.name = name;
        this.genres = genres;
    }

    public String getName() { return name; }
    public List<String> getGenres() { return genres; }
}

public class FlatMapExample {
    public static void main(String[] args) {

        /*
        flatMap() -> "achata" streams aninhadas em uma única stream

        map() sozinho geraria uma Stream<List<String>>
        - cada Manga vira uma List<String> (a lista de gêneros)
        - fica uma "lista de listas", difícil de processar direto

        flatMap() junta todas as listas internas em uma única stream de String
         */

        List<Manga> mangas = List.of(
                new Manga("Death Note", List.of("Mystery", "Thriller")),
                new Manga("Naruto", List.of("Action", "Adventure")),
                new Manga("Pokemon", List.of("Adventure", "Fantasy"))
        );

        // map() -> Stream<List<String>> (lista de listas)
        mangas.stream()
                .map(Manga::getGenres)
                .forEach(System.out::println);

        System.out.println("---");

        // flatMap() -> Stream<String> (todos os gêneros juntos, sem aninhamento)
        List<String> allGenres = mangas.stream()
                .flatMap(manga -> manga.getGenres().stream())
                .toList();
        System.out.println("allGenres -> " + allGenres);

        // distinct() pra remover gêneros repetidos entre os mangás
        List<String> distinctGenres = mangas.stream()
                .flatMap(manga -> manga.getGenres().stream())
                .distinct()
                .toList();
        System.out.println("distinctGenres -> " + distinctGenres);
    }
}