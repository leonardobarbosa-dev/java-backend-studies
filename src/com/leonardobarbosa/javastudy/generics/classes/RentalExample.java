package com.leonardobarbosa.javastudy.generics.classes;

import java.util.ArrayList;
import java.util.List;

class Car {

    private final String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}

class Boat {

    private final String model;

    public Boat(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "model='" + model + '\'' +
                '}';
    }
}

/*
RentalService<T> -> funciona com qualquer tipo de veículo
- sem genérico, precisaria de CarRentalService, BoatRentalService,
  cada uma com o mesmo código duplicado
 */

class RentalService<T> {

    private List<T> avaliable;

    public RentalService(List<T> avaliable) {
        this.avaliable = new ArrayList<>(avaliable);
    }

    public List<T> getAvaliable() {
        return avaliable;
    }

    public T rent(int index) {
        return avaliable.remove(index);
    }

    public void returnItem(T item) {
        avaliable.add(item);
    }
}

public class RentalExample {
    public static void main(String[] args) {

        RentalService<Car> carService = new RentalService<>(List.of(
                new Car( "Civic"),
                new Car( "Passat"),
                new Car( "Omega")
        ));

        System.out.println("Carros disponíveis: " +  carService.getAvaliable());

        Car rentedCar =  carService.rent(0);   // sem cast -> compilador sabe que é Car
        System.out.println("Carro alugado: " +  rentedCar);
        System.out.println("Carros disponíveis(atualização): " + carService.getAvaliable());

        carService.returnItem(rentedCar);
        System.out.println("Após devolução: " +   carService.getAvaliable());

        System.out.println("--------------------------------------------");

        RentalService<Boat> boatService = new RentalService<>(List.of(
                new Boat("Yamaha"),
                new Boat("Sea Ray")
        ));

        System.out.println("Barcos disponíveis: " +  boatService.getAvaliable());

        Boat rentedBoat = boatService.rent(0);
        System.out.println("Barco alugado: " +  rentedBoat);
        System.out.println("Barcos disponíveis(atualização): " +  boatService.getAvaliable());

        boatService.returnItem(rentedBoat);
        System.out.println("Após devolução: " +  boatService.getAvaliable());
    }
}
