package com.leonardobarbosa.javastudy.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
    public static void main(String[] args) {

        /*
        Wildcard (?) -> representa um tipo desconhecido

        ? (unbounded)      -> qualquer tipo
        ? extends T        -> T ou qualquer subtipo de T (upper bounded)
        ? super T          -> T ou qualquer supertipo de T (lower bounded)
         */

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3));
        List<Double> doubles = new ArrayList<>(List.of(1.5, 2.5, 3.5));
        List<String> strings = new ArrayList<>(List.of("a", "b", "c"));

        // ? -> aceita List de qualquer tipo, mas só permite leitura como Object
        printAll(integers);
        printAll(doubles);
        printAll(strings);

        // ? extends Number -> aceita List<Integer>, List<Double>, etc.
        // permite LEITURA como Number, mas não permite add()
        System.out.println("soma integers -> " + sum(integers));
        System.out.println("soma doubles  -> " + sum(doubles));

        // ? super Integer -> aceita List<Integer>, List<Number>, List<Object>
        // permite add(Integer), mas leitura só como Object
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("numbers após add -> " + numbers);
    }

    // ? unbounded -> só precisa iterar, não importa o tipo
    private static void printAll(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // ? extends Number -> lê como Number, mas não pode adicionar elementos
    // - o compilador não sabe o tipo exato (Integer, Double?), então proíbe add()
    private static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number number : list) {
            total += number.doubleValue();
        }
        return total;
    }

    // ? super Integer -> pode adicionar Integer, mas não sabe o tipo exato ao ler
    // - garante que a lista aceita Integer (ou supertipo dele)
    private static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }
}