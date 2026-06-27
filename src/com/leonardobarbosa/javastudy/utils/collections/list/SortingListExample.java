package com.leonardobarbosa.javastudy.utils.collections.list;

import java.util.*;

class Manga implements Comparable<Manga> {

    private Long code;
    private String name;
    private double price;

    public Manga(Long code, String name, double price) {
        Objects.requireNonNull(code, "Code não pode ser nulo.");
        Objects.requireNonNull(name, "Name não pode ser nulo.");
        this.code = code;
        this.name = name;
        this.price = price;
    }

    /*
    compareTo -> define a ordem natural da classe, usada por Collections.sort(),
    list.sort(null), TreeSet, TreeMap, etc.

    Aqui a ordenação compara só o "code" -> dois mangas com name
    ou price diferentes são lidos como "iguais" na ordenação,
    porque compareTo() retorna 0 sempre que o "code" é o mesmo.
     */
    @Override
    public int compareTo(Manga obj) {
        // this < obj   -> -1
        // this == obj  -> 0
        // this > obj   -> 1
//        if ( this.code < obj.getCode()) {
//            return -1;
//        } else if (this.code.equals(obj.getCode())) {
//            return 0;
//        } else {
//            return 1;
//        }
        // Wrappers já tem implementação do compareTo
        return Long.compare(this.code, obj.getCode());
    }

    @Override
    public String toString() {
        return "Manga{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Manga manga = (Manga) obj;
        return Double.compare(price, manga.price) == 0 && Objects.equals(code, manga.code) && Objects.equals(name, manga.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price);
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class MangaComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}

public class SortingListExample {
    public static void main(String[] args) {

        /*
        list.sort() -> ordena a própria lista (in place)

        Ordenação natural -> precisa que a classe implemente Comparable
        (String, Integer, etc. já implementam isso por padrão)

        Comparator -> define a ordem de fora, sem precisar mudar a classe
        - obrigatório quando a classe NÃO é Comparable (caso do Product)
        - também útil pra ter mais de um critério de ordenação
         */

        List<String> names = new ArrayList<>(List.of("Pedro", "Leonardo", "Maria", "Jubileu"));

//        Collections.sort(names);    // direto por Collections
        names.sort(null);   // null -> usa a ordenação natural (Comparable) da String
        System.out.println(names);


        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(3L, "Pokemon", 17.90));
        mangas.add(new Manga(1L, "Death Note", 25.90));
        mangas.add(new Manga(4L, "Dragon Ball Z", 18.90));
        mangas.add(new Manga(2L, "Naruto", 27.90));

        Collections.sort(mangas);   // compareTo sobrescrito na classe Manga
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println();

//        Collections.sort(mangas, new MangaComparator());  // classe implementando Comparator
        mangas.sort(new MangaComparator()); // forma mais simplificada
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println();

        mangas.sort(Comparator.comparing(Manga::getName));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
