package com.leonardobarbosa.javastudy.utils.date.bridge;

import java.time.*;
import java.util.Date;

public class LegacyToNewApiExample {
    public static void main(String[] args) {

        // Ponte entre API antiga e java.time via Instant
        Date date = new Date();
        Instant instant = date.toInstant();

        // Instant -> estrutura moderna legível
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        // Conversão reversa
        Date back = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(ldt);
        System.out.println(back);
    }
}