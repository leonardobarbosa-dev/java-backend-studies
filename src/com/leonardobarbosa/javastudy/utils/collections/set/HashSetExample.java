package com.leonardobarbosa.javastudy.utils.collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Manga {
    private final Long code;
    private final String name;
    private final double price;

    public Manga(Long code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Manga manga = (Manga) obj;
        return Objects.equals(code, manga.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Manga{code=" + code + ", name='" + name + "', price=" + price + "}";
    }
}

public class HashSetExample {
    public static void main(String[] args) {

        /*
        Set -> coleção que NÃO permite elementos duplicados
        HashSet -> implementação baseada em hashCode()/equals()
        - não garante ordem de iteração
        - add()/contains()/remove() são O(1) em média, graças ao hash
         */

        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(2L, "Naruto", 27.90));
        mangas.add(new Manga(5L, "Berserker", 17.90));
        mangas.add(new Manga(1L, "Death Note", 37.90));
        mangas.add(new Manga(3L, "Dragon Ball Z", 18.90));

        for  (Manga manga : mangas) {
            System.out.println(manga);
        }

        boolean added = mangas.add(new Manga(1L, "Vinland Saga", 26.49));   // mesmo code -> equals() diz que já existe
        System.out.println("conseguiu adicionar manga com mesmo code? -> " + added);
        System.out.println("size() -> " + mangas.size());

        System.out.println("contains -> " + mangas.contains(new Manga(2L, "Bleach", 17.90)));

        mangas.remove(new Manga(2L, "Bleach", 17.90));  // remove pelo code, igual no contains
        System.out.println("Após remover: ");

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
