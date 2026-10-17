package com.leonardobarbosa.javastudy.utils.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchExample {
    public static void main(String[] args) {

        /*
        Collections.binarySearch() -> O(log n), muito mais rápido que
        percorrer a lista inteira (O(n)), mas exige que a lista já
        esteja ordenada na mesma ordem usada na busca

        Se encontrar -> retorna o índice do elemento
        Se não encontrar -> retorna um número negativo:
        -(ponto de inserção) - 1
         */

        List<Integer> numbers = new ArrayList<>(List.of(2, 0, 4, 3));

        Collections.sort(numbers);
        System.out.println(Collections.binarySearch(numbers, 2));
        System.out.println(Collections.binarySearch(numbers, 1));   // deveria ficar na posição 1.  Retorna -> -1 -1 = -2


        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(3L, "Pokemon", 17.90));
        mangas.add(new Manga(1L, "Death Note", 25.90));
        mangas.add(new Manga(4L, "Dragon Ball Z", 18.90));
        mangas.add(new Manga(2L, "Naruto", 27.90));

        Collections.sort(mangas);   // ordenação pelo compareTo -> code

        Manga mangaToSearch = new Manga(2L, "Naruto", 27.90);
        System.out.println(Collections.binarySearch(mangas, mangaToSearch));

        /*
        Se a lista estiver ordenada por um critério diferente do
        compareTo, é preciso passar o mesmo Comparator usado pra ordenar
         */

        Comparator<Manga> comparatorByPrice = new MangaComparator();
        mangas.sort(comparatorByPrice); // comparando por price

        System.out.println(Collections.binarySearch(mangas, mangaToSearch,  comparatorByPrice));

    }
}
