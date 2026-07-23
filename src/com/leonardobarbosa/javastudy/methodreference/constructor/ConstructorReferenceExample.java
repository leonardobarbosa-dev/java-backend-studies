package com.leonardobarbosa.javastudy.methodreference.constructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Car {

    private final String brand;
    private final Integer year;

    public Car(String brand, Integer year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}

public class ConstructorReferenceExample {
    public static void main(String[] args) {

        /*
        Referência a construtor -> ClassName::new

        - construtor com um argumento      -> Function<T, R>
        - construtor com dois argumentos   -> BiFunction<T, U, R>
         */

        Function<String, StringBuilder> constructorRef = StringBuilder::new;
        StringBuilder java = constructorRef.apply("Java");
        System.out.println(java);

        System.out.println("---------------------------------");

        BiFunction<String, Integer, Car> cars = Car::new;
        Car toyota = cars.apply("toyota", 2001);
        System.out.println(toyota);

    }
}
