package com.leonardobarbosa.javastudy.utils.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        /**
         * java.time.LocalDateTime — DATA + HORA (não possui fuso horário)
         * - Combinação de LocalDate + LocalTime
         * - Usar para eventos locais onde o fuso não importa
         */

        // Básico
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime parse = LocalDateTime.parse("2026-12-21T23:59:59");
        System.out.println(now);    // 2026-05-09T12:52:58.846158312
        System.out.println(parse);
        /*
        O ISO 8601 é um padrão internacional para representar datas e horas de forma padronizada, sem ambiguidade.
        Padrão → yyy-MM-ddTHH:mm:ss (T separador)
         */

        // Distância
        LocalDateTime birth = LocalDateTime.of(1999, 4, 4, 10, 30);
        long birthMonths = ChronoUnit.MONTHS.between(birth, now);
        long birthWeeks = ChronoUnit.WEEKS.between(birth, now);
        long birthDays = ChronoUnit.DAYS.between(birth, now);
        long birthHours= ChronoUnit.HOURS.between(birth, now);
        long birthMinutes = ChronoUnit.MINUTES.between(birth, now);
        System.out.println(birthWeeks);

        /*
        Os metodos são basicamente os mesmos de LocalDate e LocalTime, porém aqui tem os dois juntos
         */
    }
}
