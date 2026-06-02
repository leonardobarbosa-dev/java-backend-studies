package com.leonardobarbosa.javastudy.utils.date.legacy;

import java.util.Calendar;

public class LegacyCalendarExample {
    public static void main(String[] args) {

        // Calendar é uma abstração mutável para manipular data/hora
        Calendar calendar = Calendar.getInstance();

        // Extração de campos (MONTH começa em 0)
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // ajuste manual necessário
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(day + "/" + month + "/" + year);

        // add altera corretamente e "carrega" overflow (ex: dias -> meses)
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println(calendar.getTime());

        // roll altera sem afetar campos superiores (continua no mês atual)
        calendar.roll(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.getTime());
    }
}