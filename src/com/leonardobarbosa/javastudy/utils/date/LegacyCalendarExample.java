package com.leonardobarbosa.javastudy.utils.date;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LegacyCalendarExample {
    public static void main(String[] args) {

        /**
         * java.util.Calendar — Segunda tentativa da API legada de datas
         * - Criado para corrigir as limitações do java.util.Date
         * - Meses ainda baseados em 0 (Calendar.JANUARY = 0)
         * - API verbosa e não intuitiva
         * - Mistura conceitos de data, hora e fuso no mesmo objeto
         */

        // Obtendo instância (Calendar é abstrato → usa GregorianCalendar internamente)
        Calendar c = Calendar.getInstance();

        // Extraindo campos (MONTH começa em 0)
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1; // +1 para o mês real
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY); // 0-23
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.printf("Data: %02d/%02d/%d %02d:%02d:%02d%n", day, month, year, hour, minute, second);

        // Definindo uma data específica
        Calendar christmas = Calendar.getInstance();
        christmas.set(2026, Calendar.DECEMBER, 25); // use a constante para evitar confusão
        christmas.set(Calendar.HOUR_OF_DAY, 0);
        christmas.set(Calendar.MINUTE, 0);
        christmas.set(Calendar.SECOND, 0);
        System.out.println("Natal: " + christmas.getTime());

        // Aritmética de datas com add()
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DAY_OF_MONTH, 10); // +10 dias
        future.add(Calendar.MONTH, 2);          // +2 meses
        future.add(Calendar.YEAR, 1);           // +1 ano
        System.out.println("Futuro: " + future.getTime());

        // roll() → incrementa sem "transbordar" para o campo superior
        Calendar cd = Calendar.getInstance();
        cd.set(2026, Calendar.JANUARY, 31); // set() = define valor bruto
        cd.roll(Calendar.DAY_OF_MONTH, 1); // roll() não transborda para o campo superior (fica em janeiro, mês: 0)
//        cd.add(Calendar.DAY_OF_MONTH, 1); // retorna dia: 1 mês: 1
        System.out.println("Dia: " + cd.get(Calendar.DAY_OF_MONTH));
        System.out.println("Mês: " +  cd.get(Calendar.MONTH));

        // Comparações
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.DAY_OF_MONTH, 5); // + 5 dias

        System.out.println(c1.before(c2)); // true
        System.out.println(c1.after(c2));  // false
        System.out.println(c1.equals(c2)); // false

        // Fuso horário
        Calendar tokyo = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        int h = tokyo.get(Calendar.HOUR_OF_DAY);
        int m = tokyo.get(Calendar.MINUTE);
        int s = tokyo.get(Calendar.SECOND);
        System.out.printf("Hora em Tokyo: %02d:%02d:%02d%n", h, m, s);

        // Convertendo Calendar → Date (para usar com APIs legadas)
        Date date = c.getTime();
        System.out.println(date);
    }
}
