package com.leonardobarbosa.javastudy.utils.collections.set;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

class Book implements Comparable<Book> {

    private final Long code;
    private final String title;
    private final String description;
    private Double price;

    public Book(Long code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public Book(Long code, String title, String description, Double price) {
        this(code, title, description);
        this.price = price;
    }

    /*
    compareTo -> define a ordem natural e também a deduplicação no TreeSet
    - dois Manga com o mesmo code são lidos como iguais pelo TreeSet,
      mesmo que equals() os considere diferentes (se comparar mais campos)
    - não usar equals()/hashCode() como o HashSet: usa compareTo()
     */

    @Override
    public int compareTo(Book obj) {
        return Long.compare(this.code, obj.code);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(code, book.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);


    }

    @Override
    public String toString() {
        return "Book{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}

public class NavigableSetExample {
    public static void main(String[] args) {

        /*
        TreeSet -> Set ordenado, usa compareTo() para tudo (ordenação e deduplicação)
        NavigableSet -> interface que o TreeSet implementa, adiciona

        TreeSet com Comparator -> quando quiser ordenar por outro critério,
        passar o Comparator no construtor
         */

        NavigableSet<Book> books = new TreeSet<>();

        books.add(new Book(3L, "Mais esperto que o Diabo", "Crescimento"));
        books.add(new Book(1L, "O homem mais rico da babilônia", "Aprendizado de vida"));
        books.add(new Book(4L, "Harry Potter e a câmara secreta", "Fantasia"));
        books.add(new Book(2L, "O Hobiit", "Fantasia"));
        books.add(new Book(2L, "Code duplicado", "Code duplicado"));

        System.out.println("size() -> " + books.size());    // Ignora o code duplicado (2L)
        System.out.println("Ordenação por code:");
        for (Book book : books) {
            System.out.println(book);
        }

        Book reference = new Book(0L, "Teste duplicação", "Teste");
        System.out.println("---------------------------------------------------------------------");

        /*
        Os quatro metodos de navegação mais usados.
        flor/ceeling incluem o próprio elemento se existir
        loewe/higher são escritamente menores/maiores
         */
        System.out.println("lower() -> " + books.lower(reference)); // <
        System.out.println("floor() -> " + books.floor(reference)); // <=
        System.out.println("higher() -> " +books.higher(reference));    // >
        System.out.println("ceiling() -> " + books.ceiling(reference));   // >=

        /*
        TreeSet com Comparator -> ordena por critério externo em vez do compareTo
        - útil quando a classe nãoi é Comparable, ou quando se quer outra ordenação
         */

        NavigableSet<Book> subset = new TreeSet<>(Comparator.comparingDouble(Book::getPrice));
        subset.add(new Book(3L, "Mais esperto que o Diabo", "Crescimento", 10.99));
        subset.add(new Book(1L, "O homem mais rico da babilônia", "Aprendizado de vida", 25.99));
        subset.add(new Book(4L, "Harry Potter e a câmara secreta", "Fantasia", 7.99));
        subset.add(new Book(2L, "O Hobiit", "Fantasia", 9.99));

        System.out.println("\nsubset ordenado por price:");

        for (Book book : subset) {
            System.out.println(book);
        }
    }
}
