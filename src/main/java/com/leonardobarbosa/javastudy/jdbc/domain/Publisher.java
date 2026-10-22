package com.leonardobarbosa.javastudy.jdbc.domain;

import lombok.Builder;
import lombok.Value;

// @Value gera getters, equals(), hashCode(), toString()
// e um construtor com os campos, tornando a classe imutável.
@Value

// @Builder permite construir objetos usando o padrão Builder.
@Builder
public class Publisher {

    Integer id;
    String name;
}
