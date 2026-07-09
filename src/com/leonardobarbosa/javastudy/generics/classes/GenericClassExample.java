package com.leonardobarbosa.javastudy.generics.classes;

import java.util.ArrayList;
import java.util.List;

/*
Classe genérica -> definida com <T>, funciona com qualquer tipo
- T é substituído pelo tipo real no momento do uso
- sem genérico, a classe precisaria de um campo Object e casts manuais
 */
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Box{value=" + value + "}";
    }
}

/*
Bounded type parameter -> <T extends Comparable<T>>
- restringe T a tipos que implementam Comparable
- permite usar métodos de Comparable dentro da classe (compareTo)
 */
class MinBox<T extends Comparable<T>> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T min() {
        if (items.isEmpty()) return null;
        T min = items.get(0);
        for (T item : items) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }
}

/*
Múltiplos parâmetros de tipo -> <K, V>
- cada parâmetro representa um tipo independente
- Map<K, V> do Java usa exatamente esse padrão
 */
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }
}

public class GenericClassExample {
    public static void main(String[] args) {

        Box<String> stringBox = new Box<>("Java");
        Box<Integer> intBox = new Box<>(42);

        System.out.println(stringBox);
        System.out.println(intBox);

        String value = stringBox.getValue();   // sem cast -> compilador já sabe o tipo
        System.out.println("getValue() -> " + value);

        MinBox<Integer> minBox = new MinBox<>();
        minBox.add(5);
        minBox.add(2);
        minBox.add(8);
        minBox.add(1);
        System.out.println("min() -> " + minBox.min());

        MinBox<String> minStringBox = new MinBox<>();
        minStringBox.add("Naruto");
        minStringBox.add("Death Note");
        minStringBox.add("Pokemon");
        System.out.println("min() -> " + minStringBox.min());   // ordem alfabética

        Pair<String, Integer> pair = new Pair<>("code", 42);
        System.out.println(pair);
    }
}