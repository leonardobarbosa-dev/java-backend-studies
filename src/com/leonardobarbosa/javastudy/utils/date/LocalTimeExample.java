package com.leonardobarbosa.javastudy.utils.date;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {
    public static void main(String[] args) {

        /**
         * java.time.LocalTime — APENAS HORA (sem data, sem fuso)
         * - Imutável e thread-safe
         * - Representa hora do dia: 00:00 a 23:59:59.999999999
         * - Usar para horários de funcionamento, agendamentos, turnos
         */

        // Criando horários
        LocalTime now = LocalTime.now();
        LocalTime lunch =  LocalTime.of(12, 30 );
        LocalTime preciseTime = LocalTime.of(23, 59, 45);
        LocalTime nanoseconds = LocalTime.of(10, 30, 35, 1);
        LocalTime parse = LocalTime.parse("14:30:00");

        System.out.println(nanoseconds);

        // Constantes úteis
        System.out.println(LocalTime.MIDNIGHT);
        System.out.println(LocalTime.NOON);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);

        // Extraindo campos
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());

        // Aritmética
        LocalTime twoMore = now.plusHours(2);
        LocalTime minusThirty = now.minusMinutes(30);
        LocalTime moreFortyFive = now.plusSeconds(45);

        System.out.println(twoMore);

        // LocalTime é circular (passa da meia noite e volta para o início)
        LocalTime afternoon = LocalTime.of(23, 0);
        System.out.println(afternoon.plusHours(3));

        // with() -> altera um campo
        LocalTime newTime = now.withHour(8).withMinute(30).withSecond(30);

        // Distância entre horários
        Long minutes = ChronoUnit.MINUTES.between(lunch, parse);

        System.out.println("Minutos entre almoço e \"parse\": " + minutes);

        // Verificando horário de funcionamento
        LocalTime opening = LocalTime.of(8, 0);
        LocalTime closing  = LocalTime.of(18, 0 );
        LocalTime customer =  LocalTime.of(15, 0);

        boolean b = customer.isAfter(opening) && customer.isBefore(closing);
        System.out.println(b);
    }
}
