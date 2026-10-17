package com.leonardobarbosa.javastudy.patterns.dto;

public record UserDto(int id, String name, String email, String city, String state) {

        /*
        Record -> tipo especial de classe introduzido no Java 16,
        utilizado principalmente para representar dados.

        - Declara os atributos diretamente nos parâmetros do record.
        - Gera automaticamente o construtor, os métodos de acesso,
          equals(), hashCode() e toString().
        - Os componentes são final, não podendo ter seus valores
          reassociados após a criação do objeto.
        - Não exige getters tradicionais: o acesso é feito pelo nome
          do componente, como user.name().
        - É útil para DTOs que apenas agrupam e transportam dados.
         */
}
