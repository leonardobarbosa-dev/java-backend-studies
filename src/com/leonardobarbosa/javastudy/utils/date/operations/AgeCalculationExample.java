package com.leonardobarbosa.javastudy.utils.date.operations;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculationExample {
    public static void main(String[] args) {

        // Period: representa diferença baseada em calendário (anos, meses, dias)
        LocalDate birth = LocalDate.of(1999, 4, 4);

        int age = Period.between(birth, LocalDate.now()).getYears();

        System.out.println(age);
    }
}