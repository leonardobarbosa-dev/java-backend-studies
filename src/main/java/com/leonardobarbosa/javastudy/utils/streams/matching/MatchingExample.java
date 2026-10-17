package com.leonardobarbosa.javastudy.utils.streams.matching;

import java.util.List;
import java.util.Optional;

class Manga {
    private final String name;
    private final double price;

    public Manga(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Manga{name='" + name + "', price=" + price + "}";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class MatchingExample {
    public static void main(String[] args) {

        /*
        Operações terminais que retornam boolean ou Optional,
        param assim que encontram o resultado (short-circuit)
        - não precisam percorrer a stream inteira

        anyMatch()   -> algum elemento satisfaz a condição?
        allMatch()   -> todos os elementos satisfazem a condição?
        noneMatch()  -> nenhum elemento satisfaz a condição?
        findFirst()  -> retorna o primeiro elemento (Optional)
        findAny()    -> retorna qualquer elemento (útil em stream paralela)
         */

        List<Manga> mangas = List.of(
                new Manga("Death Note", 25.90),
                new Manga("Naruto", 27.90),
                new Manga("Pokemon", 17.90)
        );

        // anyMatch
        System.out.println(mangas.stream()
                .anyMatch(manga -> manga.getPrice() > 25));

        // allMatch
        System.out.println(mangas.stream()
                .allMatch(manga -> manga.getPrice() > 25));

        // noneMatch
        System.out.println(mangas.stream()
                .noneMatch(manga -> manga.getPrice() == 0));

        // findFirst
        mangas.stream()
                .filter(manga -> manga.getPrice() > 20)
                .findFirst()
                .ifPresent(System.out::println);

        // findAny
        mangas.stream()
                .filter(manga -> manga.getPrice() > 20)
                .findAny()
                .ifPresent(System.out::println);

        // caso sem resultado -> Optional vazio
        System.out.println(mangas.stream()
                .filter(manga -> manga.getPrice() > 100)
                .findFirst()
                .isEmpty());
    }
}