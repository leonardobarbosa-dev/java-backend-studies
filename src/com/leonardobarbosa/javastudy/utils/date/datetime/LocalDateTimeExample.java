package com.leonardobarbosa.javastudy.utils.date.datetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        // Combina data + hora (sem fuso horário)
        LocalDateTime now = LocalDateTime.now();

        // Representa um instante local específico
        LocalDateTime birth = LocalDateTime.of(1999, 4, 4, 10, 30);

        // Diferença em unidades de tempo
        long days = ChronoUnit.DAYS.between(birth, now);

        System.out.println(now);
        System.out.println(days);
    }
}