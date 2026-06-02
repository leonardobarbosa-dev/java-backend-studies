package com.leonardobarbosa.javastudy.utils.date.operations;

import java.time.LocalDate;

public class DateRangeExample {
    public static void main(String[] args) {

        // Geração de sequência de datas (intervalo fechado/aberto)
        LocalDate start = LocalDate.now();

        start.datesUntil(start.plusDays(7)).forEach(System.out::println);
    }
}