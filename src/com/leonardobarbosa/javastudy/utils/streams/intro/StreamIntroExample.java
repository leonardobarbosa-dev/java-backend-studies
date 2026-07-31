package com.leonardobarbosa.javastudy.utils.streams.intro;

import java.util.List;

class Manga {
    private final Long code;
    private final String name;
    private final double price;

    public Manga(Long code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Manga{code=" + code + ", name='" + name + "', price=" + price + "}";
    }
}

public class StreamIntroExample {
    public static void main(String[] args) {

        /*
        Stream -> sequência de elementos que permite processar dados
        de forma declarativa, encadeando operações

        Diferente de uma coleção:
        - não guarda dados, apenas processa os que vêm de uma fonte (List, array, etc.)
        - é consumida uma única vez -> depois de percorrida, não pode ser reutilizada
        - operações intermediárias (filter, map) são LAZY -> só executam
          quando uma operação terminal (forEach, collect) é chamada

        Pipeline típico:
        fonte -> operações intermediárias -> operação terminal
         */

        List<Manga> mangas = List.of(
                new Manga(1L, "Death Note", 25.90),
                new Manga(2L, "Naruto", 27.90),
                new Manga(3L, "Pokemon", 17.90)
        );

        /*
        stream() -> cria a stream a partir da lista
        filter() -> operação intermediária, retorna outra stream
        forEach() -> operação terminal, consome a stream
         */
        mangas.stream()
                .filter(manga -> manga.getPrice() > 20)
                .forEach(System.out::println);


        /*
        map() -> operação intermediária, transforma cada elemento
        - recebe uma Function<T, R>, aplicada em cada elemento
        - muda o tipo da stream: aqui, Stream<Manga> vira Stream<String>

        toList() -> operação terminal que reúne o resultado
        numa lista imutável -> add()/remove() lançam UnsupportedOperationException

        - se precisar de uma lista mutável, usar collect(Collectors.toList())
         */
        List<String> names = mangas.stream()
                .map(Manga::getName)
                .toList();
        System.out.println("Names -> " + names);


        // Stream não pode ser reutilizada -> cada stream() cria uma nova
        var stream = mangas.stream();   // var -> compilador infere -> Stream<Manga>
        stream.forEach(System.out::println);

        try{
            stream.forEach(System.out::println);    // erro -> stream já foi consumida
        } catch (IllegalStateException e) {
            System.out.println("erro -> " + e.getMessage());
        }
    }
}
