package com.leonardobarbosa.javastudy.methodreference.staticmethod;

import java.util.List;
import java.util.function.Function;

public class StaticMethodReferenceExample {
    public static void main(String[] args) {

        /*
        Referência a metodo estático -> ClassName::staticMethod
        Substitui uma lambda que apenas chama um metodo estático existente

        lambda:           str -> Integer.parseInt(str)
        method reference: Integer::parseInt
        São equivalentes -> o compilador trata os dois da mesma forma
         */

        Function<String, Integer> lambda = str -> Integer.parseInt(str);
        Function<String, Integer> methodRef = Integer::parseInt;

        System.out.println("lambda     -> " + lambda.apply("42"));
        System.out.println("methodRef  -> " + methodRef.apply("42"));

        List<String> numbers = List.of("1", "2", "3", "4");

        numbers.stream()
                .map(str -> Integer.parseInt(str))    // lambda
                .forEach(n -> System.out.println("lambda    -> " + n));

        numbers.stream()
                .map(Integer::parseInt)               // method reference
                .forEach(n -> System.out.println("methodRef -> " + n));

        // System.out::println -> referência ao metodo println da instância System.out
        List<String> values = List.of("hello", "world");
        values.forEach(System.out::println);
    }
}