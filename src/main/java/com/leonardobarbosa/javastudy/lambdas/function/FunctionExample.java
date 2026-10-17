package com.leonardobarbosa.javastudy.lambdas.function;

import java.util.List;
import java.util.function.Function;

class Car {
    private final String brand;
    private final String color;
    private final int year;

    public Car(String brand, String color, int year) {
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', color='" + color + "', year=" + year + "}";
    }
}

public class FunctionExample {
    public static void main(String[] args) {

        /*
        Function<T, R> -> recebe T e retorna R
        - apply(T t)     -> aplica a função e retorna o resultado
        - andThen(F f)   -> encadeia funções: aplica this, passa o resultado pra f
        - compose(F f)   -> encadeia funções: aplica f primeiro, passa o resultado pra this

        Diferença das outras interfaces funcionais:
        - Predicate<T>      -> recebe T, retorna boolean
        - Consumer<T>       -> recebe T, retorna void
        - Function<T, R>    -> recebe T, retorna R (qualquer tipo)
         */

        Function<Car, String> getBrand = car -> car.getBrand();
        Function<Car, Integer> getYear = car -> car.getYear();
        Function<String, String> toUpperCase = str -> str.toUpperCase();

        Car car = new Car("Toyota", "red", 2020);

        System.out.println("apply() brand    -> " + getBrand.apply(car));
        System.out.println("apply() year     -> " + getYear.apply(car));

        // andThen() -> aplica getBrand primeiro, passa o resultado pra toUpperCase
        Function<Car, String> brandUpperCase = getBrand.andThen(toUpperCase);
        System.out.println("andThen()        -> " + brandUpperCase.apply(car));



        /*
        Function<String, String> addPrefix = new Function<>() {
            @Override
            public String apply(String str) {
                return "Brand: " + str;
            }
        };
         */
        Function<String, String> addPrefix = str -> "Brand: " + str;

        // andThen() -> addPrefix primeiro, depois toUpperCase
        Function<String, String> prefixThenUpper = addPrefix.andThen(toUpperCase);

        // "toyota" -> addPrefix -> "Brand: toyota" -> toUpperCase -> "BRAND: TOYOTA"
        System.out.println("andThen() -> " + prefixThenUpper.apply("toyota"));

        // compose() -> toUpperCase primeiro, depois addPrefix
        Function<String, String> upperThenPrefix = addPrefix.compose(toUpperCase);

        // "toyota" -> toUpperCase -> "TOYOTA" -> addPrefix -> "Brand: TOYOTA"
        System.out.println("compose() -> " + upperThenPrefix.apply("toyota"));


        // uso mais comum no dia a dia: stream().map() recebe Function<T, R>
        List<Car> cars = List.of(
                new Car("Toyota", "red", 2020),
                new Car("Honda", "blue", 2018),
                new Car("Ford", "red", 2019)
        );

        cars.stream()
                .map(getBrand)   // Function<Car, String> -> transforma Car em String
                .forEach(System.out::println);
    }
}