package com.leonardobarbosa.javastudy.utils.date.localdate;

import java.time.LocalDate;

public class LocalDateBasicExample {
    public static void main(String[] args) {

        // LocalDate representa APENAS data (sem hora e sem fuso)
        LocalDate today = LocalDate.now();

        // Criação explícita (ano, mês, dia)
        LocalDate birth = LocalDate.of(1999, 4, 4);

        System.out.println(today);
        System.out.println(birth);

        // Operações são imutáveis (retornam novos objetos)
        LocalDate future = today.plusDays(10);
        LocalDate past = today.minusMonths(2);

        System.out.println(future);
        System.out.println(past);

        // Comparações de linha do tempo
        System.out.println(today.isBefore(birth));
        System.out.println(today.isAfter(birth));
    }
}