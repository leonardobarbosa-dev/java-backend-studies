package com.leonardobarbosa.javastudy.utils.collections.iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class Manga {
    private Long code;
    private String name;
    private double price;
    private int amount;

    public Manga(Long code, String name, double price, int amount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
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

    public int getAmount() {
        return amount;
    }
}

public class IteratorExample {
    public static void main(String[] args) {

        /*
        Iterator -> percorre uma coleção sem expor como ela é
        implementada por dentro (lista, árvore, etc.)

        hasNext() -> tem mais elemento?
        next()    -> avança e retorna o elemento
        remove()  -> remove o último elemento retornado por next()

        for-each (for (Manga manga : mangas)) usa Iterator por baixo dos panos,
        mas não dá acesso ao remove() dele
         */


        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(1L, "Pokemon", 17.90, 0));
        mangas.add(new Manga(2L, "Death Note", 25.90, 5));
        mangas.add(new Manga(3L, "Dragon Ball Z", 18.90, 2));
        mangas.add(new Manga(4L, "Naruto", 27.90, 0));

        // removeIf() -> metodo que já vem dentro da interface Collection
        // - é literalmente o mesmo código escrito abaixo com o Iterator
        mangas.removeIf(manga -> manga.getAmount() == 0);

//        Iterator<Manga> iterator = mangas.iterator();

//        while (iterator.hasNext()) {
//            Manga manga = iterator.next();
//            if (manga.getAmount() == 0) {
//                iterator.remove();  // seguro pois usa o próprio Iterator, não a List
//            }
//        }

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("---------------------------------------------------");

        /*
        Usar list.remove() dentro de um for-each:
        a List percebe que foi modificada "por fora" do Iterator
        que o for-each está usando, e lança ConcurrentModificationException
         */

        List<String> names = new ArrayList<>(List.of("Vegeta", "Pain", "Goku", "Naruto", "Gaara"));

        try {
            for (String name : names) {
                if(name.startsWith("G")) {
                    names.remove(name);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Erro -> "  + e.getMessage());
        }

        /*
        Além da exceção, o loop quebra no meio, então elementos
        que vêm depois do que foi removido nunca chegam a ser testados.

        "Gaara" também começa com "G", mas a exceção interrompe o for-each
        antes de chegar nele -> ele escapa da remoção, mesmo cumprindo a condição.

        Por isso, capturar a exceção não resolve nada -> a lista fica
        processada pela metade, de forma inconsistente.
         */
        System.out.println(names);  // Goku foi removido mas Gaara continua pois a exceção foi lançada antes de chegar nele
    }
}
