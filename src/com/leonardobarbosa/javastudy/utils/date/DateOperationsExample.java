package com.leonardobarbosa.javastudy.utils.date;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class DateOperationsExample {
    public static void main(String[] args) {

        /**
         * Exemplos de cálculos reais que aparecem no dia a dia de desenvlvimento
         */

        LocalDate now = LocalDate.now();

        // 1. Calcular idade
        LocalDate birth = LocalDate.of(1999, 4, 4);
        int anos = Period.between(birth, now).getYears();
        System.out.println("Idade: " + anos + " anos");

        // 2. Verificar se uma data já passou
        LocalDate term = LocalDate.of(2026, 1, 1);
        System.out.println("Prazo vencido: " + term.isBefore(now));

        // 3. Próximo dia útil (ignora sábado e domingo)
        LocalDate nextBusinessDay = now;
        do {
            nextBusinessDay = nextBusinessDay.plusDays(1);
        } while (nextBusinessDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
                nextBusinessDay.getDayOfWeek() == DayOfWeek.SUNDAY);
        System.out.println("Próximo dia útil: " + nextBusinessDay);

        // 4. Primeiro e último dia do mês
        LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay   = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Início do mês: " + firstDay);
        System.out.println("Fim do mês: "    + lastDay);

        // 5. Dias úteis no mês (sem fins de semana) (.filter = Stream)
        long BusinessDays = firstDay.datesUntil(lastDay.plusDays(1))
                .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY &&
                        d.getDayOfWeek() != DayOfWeek.SUNDAY)
                .count();
        System.out.println("Dias úteis no mês: " + BusinessDays);

        // 6. Verificar se é ano bissexto
        System.out.println("Bissexto: " + now.isLeapYear());

        // 7. Data com timezone para exibir hora local e UTC
        ZonedDateTime nowSP = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime nowUTC = nowSP.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("SP:  " + nowSP.toLocalDateTime());
        System.out.println("UTC: " + nowUTC.toLocalDateTime());

        // 8. Tempo restante até meia-noite
        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime startDay = timeNow.toLocalDate().plusDays(1).atStartOfDay();
        Duration remaining = Duration.between(timeNow, startDay);
        System.out.println("Tempo até a meia noite: " + remaining);

        // 9. Geração de intervalo de datas (Java 9+)
        LocalDate start = LocalDate.of(2026, 5, 1);
        LocalDate end = LocalDate.of(2026, 5, 7);
        System.out.println("Dias da semana:");
        start.datesUntil(end.plusDays(1))
                .forEach(d -> System.out.println("  " + d + " → " + d.getDayOfWeek()));
    }
}
