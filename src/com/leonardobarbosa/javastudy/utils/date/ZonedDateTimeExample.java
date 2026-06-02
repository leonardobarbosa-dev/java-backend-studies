package com.leonardobarbosa.javastudy.utils.date;

import java.time.*;

public class ZonedDateTimeExample {
    public static void main(String[] args) {

        /**
         * java.time.ZonedDateTime — DATA + HORA + FUSO HORÁRIO
         * Representa um momento exato na linha do tempo, em um fuso específico
         * Usar quando o sistema envolve múltioplos países, converter horários,
         * precisa respeitar horário de verão...
         */

        // Ver todas  as zonas disponíveis
//        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

        // Exemplo
        ZonedDateTime sp = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime systemNow = ZonedDateTime.now(ZoneId.systemDefault());    // Hora + Data + Zona do sistema
        System.out.println(sp);
        System.out.println(ZoneId.systemDefault()); // Zona do sistema

        // Conversão - converte um horário já existente para outro fuso, sem mudar o instante real
        ZonedDateTime newYear = ZonedDateTime.of(2026, 12, 31, 23, 59, 59, 0, ZoneId.of("America/Recife"));
        ZonedDateTime tokyo = newYear.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyo);

        // UTC - Coordinated Universal Time
        ZoneId utc = ZoneId.of("UTC");
        LocalDateTime utcTime = LocalDateTime.now(utc);
        System.out.println(utcTime);

        // OffsetDateTime - Usar quando precisar de um deslocamento específico em relação ao UTC (ex: -03:00)
        OffsetDateTime utcOffset = OffsetDateTime.now(ZoneOffset.of("-03:00"));
        System.out.println(utcOffset);
        /*
        Não sabe a região e não aplica regras de horário de verão
        Se uma região mudar o horário - ZonedDateTime ajusta automaticamente
        OffsetDateTime - não ajusta
         */
    }
}
