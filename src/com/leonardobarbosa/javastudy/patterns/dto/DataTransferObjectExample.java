package com.leonardobarbosa.javastudy.patterns.dto;

public class DataTransferObjectExample {

    /*
    DTO (Data Transfer Object) -> objeto utilizado para agrupar
    e transportar dados entre diferentes partes de uma aplicação.

    - Reúne vários valores em um único objeto.
    - Não deve concentrar regras de negócio.
    - Pode ser implementado com uma classe ou um record.
    */

    public static void main(String[] args) {

        User user = new User(1, "Leonardo", "leonardo@email.com");
        Adress adress = new Adress("Santa cruz", "PE");

        UserDto userDto = UserDtoMapper.toDto(user, adress);

        System.out.println("ID: " + userDto.id());
        System.out.println("Name: " + userDto.name());
        System.out.println("E-mail: " + userDto.email());
        System.out.println("City: " + userDto.city());
        System.out.println("State: " + userDto.state());
    }
}
