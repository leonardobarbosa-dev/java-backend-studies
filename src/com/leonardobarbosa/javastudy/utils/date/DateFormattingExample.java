package com.leonardobarbosa.javastudy.utils.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormattingExample {
    public static void main(String[] args) {

        /**
         * FORMATAÇÃO E PARSING COM DateTimeFormatter
         * - Imutável e thread-safe (ao contrário do antigo SimpleDateFormat)
         * - Três formas de usar: padrões prontos, padrões customizados, FormatStyle

         * SÍMBOLOS COMUNS DE PADRÃO:
         * y = ano    M = mês (número)   MMM = mês (abrev)  MMMM = mês (completo)
         * d = dia    H = hora (0-23)    h = hora (1-12)
         * m = minuto s = segundo        a = AM/PM
         * E = dia da semana (abrev)     EEEE = dia completo
         * z = fuso (nome)               Z = offset (+0300)  XXX = offset (-03:00)
         */

        LocalDate date     = LocalDate.of(2026, 5, 6);
        LocalTime time     = LocalTime.of(20, 13, 27);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("America/Recife"));

        // Formatadores prontos (ISO padrão)
        System.out.println(DateTimeFormatter.ISO_DATE.format(date));             // 2026-05-06
        System.out.println(DateTimeFormatter.ISO_TIME.format(time));             // 20:13:27
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(dateTime));          // 2026-05-06T20:13:27
        System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDateTime));   // com fuso
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(zonedDateTime));           // UTC

        // Padrões customizados
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formatWithDay = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy", Locale.of("pt", "BR"));

        System.out.println(formatDate.format(date));       // 06/05/2026
        System.out.println(formatDateTime.format(dateTime));     // 06/05/2026 20:13:27
        System.out.println(formatWithDay.format(date));       // quarta-feira, 06 de maio de 2026

        // FormatStyle → estilo localizado automático
        DateTimeFormatter shortDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.of("pt","BR"));
        DateTimeFormatter mediumDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.of("pt","BR"));
        DateTimeFormatter longDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.of("pt","BR"));

        System.out.println(shortDate.format(date));  // 06/05/26
        System.out.println(mediumDate.format(date));  // 06 de <mediumMonth> de2026
        System.out.println(longDate.format(date));  // 6 de maio de 2026

        // Parsing → String para objeto java.time
        LocalDate parseOne = LocalDate.parse("06/05/2026", formatDate);
        LocalDateTime parseTwo = LocalDateTime.parse("06/05/2026 20:13:27", formatDateTime);
        LocalDate parseThree = LocalDate.parse("2026-05-06"); // ISO padrão (não precisa de formatter)

        System.out.println(parseOne);  // 2026-05-06
        System.out.println(parseTwo);  // 2026-05-06T20:13:27
        System.out.println(parseThree);  // 2026-05-06

        // Formato do parse deve bater exatamente com a string
        try {
            LocalDate.parse("06-05-2026", formatDate); // dd/MM/yyyy esperado, mas veio dd-MM-yyyy
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Formato inválido: " + e.getMessage());
        }
    }
}
