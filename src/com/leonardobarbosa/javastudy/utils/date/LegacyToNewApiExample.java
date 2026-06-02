package com.leonardobarbosa.javastudy.utils.date;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class LegacyToNewApiExample {
    public static void main(String[] args) {

        /**
         * PONTE ENTRE API LEGADA E java.time
         * Conversões que você vai encontrar ao trabalhar com código legado,
         * JDBC e JPA. O ponto central é sempre passar pelo Instant.

         * REGRA GERAL:
         * Legado → Instant → java.time
         * java.time → Instant → Legado
         */

        // Date <-> Instant
        Date date       = new Date();
        Instant dateForInstant = date.toInstant();
        Date instantForDate = Date.from(Instant.now());
        System.out.println("Date para Instant: " + dateForInstant);
        System.out.println("Instant para Date: " + instantForDate);

        // Instant → LocalDateTime (precisando de data legível)
        LocalDateTime ldt = dateForInstant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Instant para LocalDateTime: " + ldt);

        // LocalDateTime → Date
        Date ldtForDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime para Date: " + ldtForDate);

        // Calendar → Instant
        Calendar cal        = Calendar.getInstance();
        Instant instCal     = cal.toInstant();
        LocalDateTime ldtCal = instCal.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Calendar para LocalDateTime: " + ldtCal);

        // --- sql.Date <-> LocalDate (JDBC) ---
        java.sql.Date localDateForSql = java.sql.Date.valueOf(LocalDate.now());
        LocalDate sqlDateForLocalDate = localDateForSql.toLocalDate();
        System.out.println("LocalDate para sql.Date: " + localDateForSql);
        System.out.println("sql.Date para LocalDate: " + sqlDateForLocalDate);

        // sql.Timestamp <-> LocalDateTime (JPA/JDBC)
        java.sql.Timestamp ldtForTimestamp = java.sql.Timestamp.valueOf(LocalDateTime.now());
        LocalDateTime timestampForLocalDateTime = ldtForTimestamp.toLocalDateTime();
        System.out.println("LocalDateTime para Timestamp: " + ldtForTimestamp);
        System.out.println("Timestamp para LocalDateTime: " + timestampForLocalDateTime);
    }
}
