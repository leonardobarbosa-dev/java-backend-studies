package com.leonardobarbosa.javastudy.utils.date.operations;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BusinessDaysExample {
    public static void main(String[] args) {

        // Filtra apenas dias úteis dentro de um intervalo
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(10);

        long businessDays = start.datesUntil(end)
                .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY).count();

        System.out.println(businessDays);
    }
}