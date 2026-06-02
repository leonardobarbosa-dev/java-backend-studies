package com.leonardobarbosa.javastudy.utils.date.zoned;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeBasicExample {
    public static void main(String[] args) {

        // ZonedDateTime inclui data + hora + fuso horário
        ZonedDateTime sp = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        System.out.println(sp);
        System.out.println(tokyo);
    }
}