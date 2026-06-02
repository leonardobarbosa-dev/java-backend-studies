package com.leonardobarbosa.javastudy.utils.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
    public static void main(String[] args) {

        /**
         * java.time.LocalDate — APENAS DATA (sem hora, sem fuso)
         * - Imutável e thread-safe (qualquer operação retorna novo objeto)
         * - Parte do java.time introduzido no Java 8
         * - Usar quando só a data importa: aniversários, prazos, datas de nascimento
         */

        // Criando datas
        LocalDate today = LocalDate.now();
        LocalDate christmas = LocalDate.of(2026, 12, 25);
        LocalDate perMonth = LocalDate.of(2026, Month.MAY, 4); // mesma ideia usando ENUM (Month)
        LocalDate parse = LocalDate.parse("2026-12-31"); // converte String para LocalDate - padrão (yyyy-MM-dd)

        System.out.println(today);

        // Extraindo campos
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getDayOfMonth());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getDayOfYear());
        System.out.println(today.lengthOfMonth());
        System.out.println(today.isLeapYear()); // verifica se é ano bissexto (366 dias)

        // Aritmética - imutável (sempre retorna novo objeto)
        LocalDate tenMore = today.plusDays(10);
        LocalDate leastTwoMonths = today.minusMonths(2);
        LocalDate oneMoreYear = today.plusYears(1);

        // Comparações
        System.out.println(today.isBefore(christmas));
        System.out.println(today.isAfter(christmas));
        System.out.println(today.isEqual(today));

        // Distância entre datas
        long days = ChronoUnit.DAYS.between(today, christmas);
        long months = ChronoUnit.MONTHS.between(today, christmas);
        System.out.println("Dias até o Natal: " + days);
        System.out.println("Meses até o Natal: " + months);

        // TemporalAdjusters -> ajustes sofisticados de data
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate lastDay =  today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate firstDatOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate thirdThursday = today.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.THURSDAY));

        System.out.println(thirdThursday);
    }
}
