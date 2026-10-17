package com.leonardobarbosa.javastudy.utils.date.legacy;

import java.util.Date;

public class LegacyDateExample {
    public static void main(String[] args) {

        // Date representa instante absoluto (epoch ms desde 1970)
        Date now = new Date();
        System.out.println(now);

        // Conversão para timestamp (base de quase tudo em sistemas legados)
        long timestamp = now.getTime();
        System.out.println(timestamp);

        // Comparação baseada em tempo absoluto
        Date past = new Date(2010);
        Date future = new Date(2100);

        System.out.println(past.before(future));
        System.out.println(future.after(past));

        // PROBLEMA: objeto mutável (estado pode ser alterado externamente)
        now.setTime(0);
        System.out.println(now);
    }
}