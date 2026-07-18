package com.leonardobarbosa.javastudy.lambdas.predicate;

import java.util.List;
import java.util.function.Predicate;

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

public class PredicateExample {
    public static void main(String[] args) {

        /*
        Predicate<T> -> interface funcional que recebe T e retorna boolean
        - test(T t) -> avalia o predicado
        - and()     -> combina dois predicados com &&
        - or()      -> combina dois predicados com ||
        - negate()  -> inverte o resultado (!)
         */

        List<Car> cars = List.of(
                new Car("Toyota", "red", 2020),
                new Car("Honda", "blue", 2018),
                new Car("Toyota", "blue", 2022),
                new Car("Ford", "red", 2019)
        );

        Predicate<Car> isRed = car -> car.getColor().equals("red");
        Predicate<Car> isToyota = car -> car.getBrand().equals("Toyota");
        Predicate<Car> isAfter2019 = car -> car.getYear() > 2019;

        System.out.println("test() isRed -> " + isRed.test(cars.get(0)));     // Toyota/red
        System.out.println("test() isRed -> " + isRed.test(cars.get(1)));     // Honda/blue

        // and() -> ambos precisam ser true
        Predicate<Car> isRedAndToyota = isRed.and(isToyota);
        cars.stream()
                .filter(isRedAndToyota)
                .forEach(car -> System.out.println("and() -> " + car));

        // or() -> pelo menos um precisa ser true
        Predicate<Car> isRedOrToyota = isRed.or(isToyota);
        cars.stream()
                .filter(isRedOrToyota)
                .forEach(car -> System.out.println("or()  -> " + car));

        // negate() -> inverte o resultado
        Predicate<Car> isNotRed = isRed.negate();
        cars.stream()
                .filter(isNotRed)
                .forEach(car -> System.out.println("negate() -> " + car));

        // combinando os três
        Predicate<Car> complex = isToyota.and(isAfter2019).or(isRed.negate());
        cars.stream()
                .filter(complex)
                .forEach(car -> System.out.println("complex  -> " + car));
    }
}