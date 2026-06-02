package com.leonardobarbosa.javastudy.utils.date;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationPeriodExample {
    public static void main(String[] args) {

        /**
         * MEDINDO INTERVALOS DE TEMPO

         * Duration → intervalo baseado em tempo (horas, minutos, segundos, nanos)
         *            Use com: Instant, LocalTime, LocalDateTime, ZonedDateTime

         * Period   → intervalo baseado em calendário (anos, meses, dias)
         *            Use com: LocalDate

         * ChronoUnit.between() → forma direta de obter a diferença em uma unidade específica
         */

        // Duration (baseado em tempo)
        LocalTime start = LocalTime.now();
        LocalTime end = LocalTime.now().plusHours(14);
        Duration duration = Duration.between(start, end);
        System.out.println(duration);
        /*
        LocalTime não sabe que virou o dia, então se .now() for 18:00 + 14hrs = 08:00
        O java faz 08:00 - 18:00 que resulta no retorno negativo -10hrs
        (O correto seria usar LocalDateTime)
         */

        // Duration (diretamente)
        Duration durationOne = Duration.ofHours(3);
        Duration durationTwo = Duration.ofMinutes(90);
        Duration durationThree = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(durationThree);

        // Duration com instant
        Instant instantOne = Instant.now();
        Instant instantTwo = instantOne.plusSeconds(600);
        Duration durationInst = Duration.between(instantOne, instantTwo);
        System.out.println(durationInst);
        System.out.println(durationInst.toMinutesPart());

        /*
        --------------------------------------------------------------------------------------------
         */

        //Period (baseado em calendário)
        LocalDate birth = LocalDate.of(1999, 4, 4);
        LocalDate now = LocalDate.now();
        Period age = Period.between(birth, now);
        System.out.println(age);

        // Period (diretamente)
        Period periodOne = Period.ofYears(1);
        Period periodTwo = Period.ofMonths(2);
        Period periodThree = Period.of(3, 4, 12);
        LocalDate term =  LocalDate.now().plusDays(3);
        System.out.println(term);

        /**
         * Period e Duration não se misturam
         * Duration não funciona com LocalDate
         * Period não funciona com LocalTime/Instant
         */

        // ChronoUnit.between() = diferença em unidade única
        long daysUntilChristmas = ChronoUnit.DAYS.between(now, LocalDate.of(2026, 12, 25));
        long monthsUntilChristmas = ChronoUnit.MONTHS.between(now, LocalDate.of(2026, 12, 25));
        System.out.println("Dias até o Natal: " + daysUntilChristmas);
        System.out.println("Meses até o Natal: " + monthsUntilChristmas);

        // Negativos quando a primeira data é depois da segunda
        long negative = ChronoUnit.DAYS.between(now, birth);
        System.out.println("Dias (negativo): " + negative);
    }
}
