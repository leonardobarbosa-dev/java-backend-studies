package com.leonardobarbosa.javastudy.methodreference.instancemethod;

import java.util.List;

class Car {

    private final String brand;
    private final int year;

    public Car(String brand, int year) {
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

    public void printCar() {
        System.out.println("Método de instancia da classe -> Car{brand='" + brand + "', year='" + year + "'}");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}

public class InstanceMethodReferenceExample {
    public static void main(String[] args) {

        /*
        Referência a metodo de instância -> dois tipos:

        1. Instância específica (bound) -> object::method
           - o objeto já é conhecido, a referência está "presa" a ele
           - ex: System.out::println -> System.out é o objeto fixo

        2. Tipo arbitrário (unbound) -> ClassName::method
           - o objeto vem do fluxo (stream, lambda, etc.)
           - equivale a: item -> item.method()
         */

        List<Car> cars = List.of(
                new Car("Toyota", 2020),
                new Car("Honda", 2018),
                new Car("Ford", 2019)
        );

        // bound -> System.out é a instância específica conhecida
        cars.forEach(System.out::println);   // equivale a: car -> System.out.println(car)

        System.out.println("----------------");

        // unbound -> o Car vem do stream, é o receptor do metodo
        cars.stream()
                .map(Car::getBrand)          // equivale a: car -> car.getBrand()
                .forEach(System.out::println);


        System.out.println("----------------");

        // metodo de instância próprio da classe
        cars.forEach(Car::printCar);            // equivale a: car -> car.print()
    }
}
