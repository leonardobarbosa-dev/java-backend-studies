package com.leonardobarbosa.javastudy.utils.streams.reduce;

import java.util.List;
import java.util.Optional;

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

public class ReduceExample {
    public static void main(String[] args) {

        /*
        reduce() -> combina todos os elementos da stream em um único resultado
        - aplica a operação repetidamente: (acumulado, próximo) -> novo acumulado

        Duas formas:
        reduce(BinaryOperator<T>)              -> retorna Optional<T> (stream pode estar vazia)
        reduce(T identity, BinaryOperator<T>)  -> retorna T direto (identity é o valor inicial/padrão)
         */

        List<Manga> mangas = List.of(
                new Manga("Death Note", 25.70),
                new Manga("Naruto", 27.90),
                new Manga("Pokemon", 17.90)
        );

        // sem identity -> Optional, pois a stream poderia estar vazia
        Optional<Double> totalOptional = mangas.stream()
                .map(Manga::getPrice)
                .reduce((total, price) -> total + price);
        System.out.println("reduce() sem identity -> " + totalOptional.orElse(0.0));

        // com identity -> valor inicial garantido, retorno direto (sem Optional)
        double total = mangas.stream()
                .map(Manga::getPrice)
                .reduce(0.0, (acc, price) -> acc + price);
        System.out.println("reduce() com identity -> " + total);

        // reduce() também serve pra achar o maior/menor, concatenar Strings, etc.
        double maxPrice = mangas.stream()
                .map(Manga::getPrice)
                .reduce(0.0, Double::max);
        System.out.println("reduce() max -> " + maxPrice);

        String allNames = mangas.stream()
                .map(Manga::getName)
                .reduce("", (acc, name) -> acc.isEmpty() ? name : acc + ", " + name);
        System.out.println("reduce() concat -> " + allNames);
    }
}

