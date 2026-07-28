package com.leonardobarbosa.javastudy.utils.optional;

import java.util.List;
import java.util.Optional;

class Manga {

    private final Long code;
    private final String name;

    public Manga(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

public class OptionalExample {
    public static void main(String[] args) {

        /*
        Optional<T> -> representa um valor que pode ou não estar presente
        - (quem busca é o stream/filter/repositório)
        - Optional carrega o resultado dessa busca, avisando
          se algo foi encontrado ou não

        Usado principalmente como RETORNO de métodos de busca, evitando
        null e a checagem manual (if != null) que ele exige
         */

        List<Manga> mangas = List.of(
                new Manga(1L, "Death Note"),
                new Manga(2L, "Naruto"),
                new Manga(3L, "Pokemon")
        );

        Optional<Manga> found = findByCode(mangas, 2L);     // True -> Optional com valor
        Optional<Manga> notFound = findByCode(mangas, 99L); // False -> Optional vazio

        System.out.println("isPresent() -> " + notFound.isPresent());   // isPresent() -> retorna true ou false caso exista ou não valor dentro deste Optional

        /*
        orElseThrow() -> se encontrou, retorna o valor;
        se não encontrou, lança a exceção informada
        - a forma mais comum de "obrigar" o valor a existir
         */
        Manga manga = found.orElseThrow(() -> new IllegalStateException("Manga não encontrado"));
        System.out.println("orElseThrow() -> " + manga);

        try {
            notFound.orElseThrow(() -> new IllegalStateException("Code não encontrado"));
        } catch(IllegalStateException e) {
            System.out.println("orElseThrow() -> " + e.getMessage());
        }

        /*
        orElse() -> se encontrou, retorna o valor;
        se não encontrou, retorna um valor padrão (sem lançar exceção)
         */
        Manga defaultManga = new Manga(0L, "não encontrado");
        System.out.println("orElse() -> " + notFound.orElse(defaultManga));

        /*
        ifPresent() -> executa uma ação SOMENTE se o valor existir
        - substitui o if (valor != null) { ... } tradicional
         */
        notFound.ifPresent(m -> System.out.println("Não deve imprimir isso"));

        /*
        map() -> transforma o valor, apenas se ele existir
        - se o Optional estiver vazio, o resultado também fica vazio
        - evita: if (manga != null) { return manga.getName(); }
         */
        Optional<String> name = found.map(Manga::getName);
        System.out.println("map() -> " + name.orElse("Nome não encontrado"));

        Optional<String> emptyName = notFound.map(Manga::getName);
        System.out.println("map() -> " + emptyName.orElse("Nome não encontrado"));

    }

    // metodo de busca -> retorna Optional em vez de null
    // deixa explícito, na assinatura, que o Manga pode não ser encontrado
    private static Optional<Manga> findByCode(List<Manga> mangas, Long code) {
        return mangas.stream()
                .filter(manga -> manga.getCode().equals(code))
                .findFirst();
    }
}