package com.leonardobarbosa.javastudy.utils.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        return code != null && code.equals(manga.getCode());
    }

    @Override
    public int hashCode() {
        return code == null ? 0 : this.code.hashCode();
    }

    @Override
    public String toString() {
        return "Manga{code=" + code + ", name='" + name + "', price=" + price + "}";
    }

    public Long getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

public class HashMapExample {
    public static void main(String[] args) {

        /*
        Map -> associa uma chave (key) a um valor (value), sem chaves duplicadas
        HashMap -> implementação baseada em hashCode()/equals() da chave
        - não garante ordem de iteração
        - put()/get()/containsKey()/remove() são O(1) em média
         */

        Map<Long, Manga> map = new HashMap<>();
        map.put(1L, new Manga(1L, "Death Note", 19.90));
        map.put(2L, new Manga(2L, "Naruto", 27.90));
        map.put(3L, new Manga(3L, "Pokemon", 17.90));
//        map.put(1L, new Manga(1L, "Death Note Vol.2", 29.90));    // chave duplicada sobrescreve

        Manga overwritten = map.put(1L, new Manga(1L, "Death Note Vol.2", 29.90));
        /*
        put() com o a mesma key sobrescreve a antiga no map, porém
        retorna o valor que estava associado à chave antes da alteração
         */

        System.out.println("Retornado pelo put -> " + overwritten);
        System.out.println("Valor atual do map -> " + map.get(1L)); // valor sobrescrito

        // entreySet() -> percorre pares: key e value
        for (Map.Entry<Long, Manga> entry : map.entrySet()) {
            System.out.println("key -> " + entry.getKey() + " | value -> " + entry.getValue());
        }


        /*
        LinkedHashMap -> mantém a ordem de inserção
        - mesmas operações do HashMap, mesma complexidade
        - útil quando a ordem importa
         */

        Map<Long, Manga> linkedMap = new LinkedHashMap<>();
        linkedMap.put(3L, new Manga(3L, "Pokemon", 17.90));
        linkedMap.put(1L, new Manga(1L, "Death Note", 25.90));
        linkedMap.put(2L, new Manga(2L, "Naruto", 27.90));

        System.out.println("LinkedHashMap -> " + linkedMap.keySet());   // ordem de inserção: 3, 1, 2

    }
}
