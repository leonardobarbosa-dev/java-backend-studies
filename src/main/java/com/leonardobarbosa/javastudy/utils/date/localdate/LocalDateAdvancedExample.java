package com.leonardobarbosa.javastudy.utils.date.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateAdvancedExample {
    public static void main(String[] args) {

        // ChronoUnit: calcula diferença exata entre datas
        LocalDate today = LocalDate.now();
        LocalDate christmas = LocalDate.of(2026, 12, 25);

        long days = ChronoUnit.DAYS.between(today, christmas);
        long months = ChronoUnit.MONTHS.between(today, christmas);

        System.out.println(days);
        System.out.println(months);
    }
}