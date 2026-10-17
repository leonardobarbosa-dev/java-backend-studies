package com.leonardobarbosa.javastudy.lambdas.behavior;

import java.util.ArrayList;
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

public class BehaviorParameterizationExample {
    public static void main(String[] args) {

        List<Car> cars = List.of(
                new Car("Toyota", "red", 2020),
                new Car("Honda", "blue", 2018),
                new Car("Toyota", "blue", 2022),
                new Car("Ford", "red", 2019)
        );

        /*
        Sem parametrização -> um metodo por critério de filtro
        - filterByColor e filterByBrand são idênticos, só muda o if
        - a cada novo critério, um novo metodo duplicado
         */

        System.out.println("red  -> " + filterByColor(cars, "red"));
        System.out.println("Toyota -> " + filterByBrand(cars, "Toyota"));

        /*
        Com parametrização -> um único metodo recebe o comportamento
        como argumento (Predicate<T>)
        - o "o que comparar" sai do metodo e vai pra quem chama
        - lambda define o critério no ponto de uso, sem classe separada
         */

        System.out.println("red  -> " + filter(cars, car -> car.getColor().equals("red")));
        System.out.println("Toyota -> " + filter(cars, car -> car.getBrand().equals("Toyota")));
        System.out.println("after 2019 -> " + filter(cars, car -> car.getYear() > 2019));
        System.out.println("blue Toyota -> " + filter(cars, car -> car.getColor().equals("blue") && car.getBrand().equals("Toyota")));
    }

    // sem parametrização: metodos duplicados que só diferem no if
    private static List<Car> filterByColor(List<Car> cars, String color) {
        List<Car> carByColor = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                carByColor.add(car);
            }
        }
        return carByColor;
    }

    private static List<Car> filterByBrand(List<Car> cars, String brand) {
        List<Car> carByBrand = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals(brand)) {   // única linha diferente
                carByBrand.add(car);
            }
        }
        return carByBrand;
    }

    // com parametrização: um único metodo, o critério vem de fora
    private static List<Car> filter(List<Car> cars, Predicate<Car> predicate) {
        List<Car> carByFilter = new ArrayList<>();
        for (Car car : cars) {
            if (predicate.test(car)) {   // delega a decisão pro Predicate
                carByFilter.add(car);
            }
        }
        return carByFilter;
    }
}