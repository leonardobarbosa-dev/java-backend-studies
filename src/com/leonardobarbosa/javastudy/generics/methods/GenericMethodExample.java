package com.leonardobarbosa.javastudy.generics.methods;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodExample {
    public static void main(String[] args) {

        /*
        Metodo genérico -> define <T> no próprio metodo, não na classe
        - a classe não precisa ser genérica
        - <T> é declarado antes do tipo de retorno
        - o compilador infere o tipo pelo argumento passado
         */

        System.out.println(wrap("Java"));       // T inferido como String
        System.out.println(wrap(42));           // T inferido como Integer
        System.out.println(wrap(true));         // T inferido como Boolean

        List<String> strings = List.of("Naruto", "Death Note", "Pokemon");
        List<Integer> integers = List.of(3, 1, 2, 6, 8, 5, 4);

        System.out.println("primeiro String  -> " + first(strings));
        System.out.println("primeiro Integer -> " + first(integers));

        List<String> copy = copy(strings);
        System.out.println("cópia -> " + copy);

        /*
        Bounded type parameter em metodo -> <T extends Comparable<T>>
        - restringe T a tipos que implementam Comparable
        - mesmo conceito do MinBox<T> em classes genéricas,
          mas aplicado a um metodo isolado
         */

        System.out.println("max strings  -> " + max(strings));
        System.out.println(strings.stream().max(String::compareTo).get());

        System.out.println("max integers -> " + max(integers));
        System.out.println(integers.stream().max(Integer::compareTo).get());
    }

    // <T> antes do retorno -> declara o tipo genérico do metodo
    private static <T> T wrap(T value) {
        return value;
    }

    private static <T> T first(List<T> list) {  // faz o mesmo que -> getFirst()
        return list.get(0);
    }

    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    // bounded -> só aceita tipos que sabem se comparar
    private static <T extends Comparable<T>> T max(List<T> list) {
        T max = list.getFirst();
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}