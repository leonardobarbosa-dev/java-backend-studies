package com.leonardobarbosa.javastudy.utils.date.localtime;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {

        // LocalTime representa apenas horário (sem data)
        LocalTime now = LocalTime.now();

        // Criação manual de horário
        LocalTime lunch = LocalTime.of(12, 30);

        System.out.println(now);
        System.out.println(lunch);

        // Operações são circulares (passam da meia-noite)
        LocalTime plus = now.plusHours(2);
        LocalTime minus = now.minusMinutes(30);

        System.out.println(plus);
        System.out.println(minus);

        // Comparação por horário do dia
        System.out.println(now.isAfter(lunch));
    }
}