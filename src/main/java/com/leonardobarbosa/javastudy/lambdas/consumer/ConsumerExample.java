package com.leonardobarbosa.javastudy.lambdas.consumer;

import java.util.List;
import java.util.function.Consumer;

class Car {
    private final String brand;
    private final String color;
    private final int year;

    public Car(String brand, String color, int year) {
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public String getColor() { return color; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', color='" + color + "', year=" + year + "}";
    }
}

public class ConsumerExample {
    public static void main(String[] args) {

        /*
        Consumer<T> -> interface funcional que recebe T e não retorna nada (void)
        - accept(T t) -> executa a ação sobre o elemento
        - andThen()   -> encadeia dois consumers, executados em sequência
        Diferença do Predicate:
        - Predicate -> recebe T, retorna boolean (testa/filtra)
        - Consumer  -> recebe T, retorna void   (consome/age sobre o elemento)
         */

        List<Car> cars = List.of(
                new Car("Toyota", "red", 2020),
                new Car("Honda", "blue", 2018),
                new Car("Toyota", "blue", 2022)
        );

        Consumer<Car> print = car -> System.out.println(car);
        Consumer<Car> printBrand = car -> System.out.println("brand -> " + car.getBrand());
        Consumer<Car> printYear = car -> System.out.println("year  -> " + car.getYear());

        // accept() -> executa o consumer em um elemento
        print.accept(cars.get(0));

        // andThen() -> encadeia consumers, executados na ordem
        Consumer<Car> printBrandAndYear = printBrand.andThen(printYear);
        printBrandAndYear.accept(cars.get(0));

        System.out.println("---");

        // forEach() recebe um Consumer -> o uso mais comum no dia a dia
        cars.forEach(print);

        System.out.println("---");

        cars.forEach(printBrand.andThen(printYear));
    }
}