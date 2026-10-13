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
        Address address = new Address("Santa Cruz", "PE");

        UserDto userDto = UserDtoMapper.toDto(user, address);

        System.out.println("ID: " + userDto.id());
        System.out.println("Nome: " + userDto.name());
        System.out.println("E-mail: " + userDto.email());
        System.out.println("Cidade: " + userDto.city());
        System.out.println("Estado: " + userDto.state());
    }
}
