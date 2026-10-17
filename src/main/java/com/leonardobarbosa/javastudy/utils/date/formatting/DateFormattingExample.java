package com.leonardobarbosa.javastudy.utils.date.formatting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingExample {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        // ISO = padrões oficiais da API
        DateTimeFormatter iso = DateTimeFormatter.ISO_DATE;

        // Padrão customizado (controle total do formato)
        DateTimeFormatter custom = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(iso.format(date));
        System.out.println(custom.format(date));
    }
}