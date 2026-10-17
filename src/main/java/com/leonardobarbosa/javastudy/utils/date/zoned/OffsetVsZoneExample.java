package com.leonardobarbosa.javastudy.utils.date.zoned;

import java.time.*;

public class OffsetVsZoneExample {
    public static void main(String[] args) {

        // ZonedDateTime aplica regras de fuso (DST etc.)
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Recife"));

        // OffsetDateTime usa deslocamento fixo (sem regras de região)
        OffsetDateTime odt = OffsetDateTime.now(ZoneOffset.of("-03:00"));

        System.out.println(zdt);
        System.out.println(odt);
    }
}