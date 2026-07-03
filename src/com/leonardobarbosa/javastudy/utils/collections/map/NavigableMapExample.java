package com.leonardobarbosa.javastudy.utils.collections.map;

import java.util.*;

class Game {

    private final Long code;
    private final String name;
    private final double price;

    public Game(Long code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(code, game.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
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

public class NavigableMapExample {
    public static void main(String[] args) {

        /*
        TreeMap -> Map ordenado pela chave, usa compareTo() ou Comparator
        NavigableMap -> interface que o TreeMap implementa, adiciona
        métodos de navegação: firstKey(), lastKey(), floorKey(), ceilingKey(), etc.

        - get()/put()/remove() são O(log n), diferente do HashMap que é O(1)
         */

        NavigableMap<Long, Game> gameMap = new TreeMap<>();

        gameMap.put(3L, new Game(3L, "God of War", 349.90));
        gameMap.put(1L, new Game(1L, "Baldurs Gate 3", 299.99));
        gameMap.put(4L, new Game(4L, "Dark Souls", 179.90));
        gameMap.put(2L, new Game(2L, "Call of Duty", 399.99));

        for (Map.Entry<Long, Game> entry : gameMap.entrySet()) {   // ordenado por key
            System.out.println("key -> " + entry.getKey() + " | value -> " + entry.getValue());
        }

        System.out.println("floorKey(2)   -> " + gameMap.floorKey(2L));     // <= 2
        System.out.println("ceilingKey(2) -> " + gameMap.ceilingKey(2L));   // >= 2
        System.out.println("lowerKey(2)   -> " + gameMap.lowerKey(2L));     //  < 2
        System.out.println("higherKey(2)  -> " + gameMap.higherKey(2L));    //  > 2

        System.out.println("headMap(2, inclusive) -> " + gameMap.headMap(2L, true).keySet());   // tudo até 2
        System.out.println("tailMap(2, inclusive) -> " + gameMap.tailMap(2L, true).keySet());   // tudo de 2 pra frente


        /*
        TreeMap com Comparator -> ordena por critério externo
        - a chave não precisa ser Comparable quando um Comparator é fornecido
         */

        NavigableMap<String, Game> byGameMap = new TreeMap<>(Comparator.naturalOrder());

        byGameMap.put("RDR", new Game(2L, "Red Dead Redemption", 349.90));
        byGameMap.put("DSL", new Game(3L, "Dark Souls", 179.90));
        byGameMap.put("SB", new Game(1L, "Stelar Blade", 299.90));

        System.out.println("Ordenado por name:");
        for (Map.Entry<String, Game> entry : byGameMap.entrySet()) {
            System.out.println("key -> " + entry.getKey() + " | value -> " + entry.getValue());
        }
    }
}
