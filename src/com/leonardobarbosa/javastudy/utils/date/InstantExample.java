package com.leonardobarbosa.javastudy.utils.date;

import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {

        /**
         * java.time.Instant — TIMESTAMP UTC
         * - Representa um ponto exato na linha do tempo (epoch = 01/01/1970T00:00:00Z)
         * - Sem fuso, sem data "legível" — só nanosegundos desde o epoch
         * - Ideal para logs de sistema, medir duração, persistência, comparar eventos
         */

        // Criando Instants
        System.out.println(Instant.now());
        System.out.println(Instant.EPOCH);         // 1970-01-01T00:00:00Z
        System.out.println(Instant.parse("2030-01-01T00:00:00Z"));
        System.out.println(Instant.ofEpochMilli(1000L)); // 1 segundo após epoch
        System.out.println(Instant.ofEpochSecond(60)); // 1 minuto após epoch

        // Medindo tempo de execução de código (não é a melhor opção na maioria dos casos)
        Instant init = Instant.now();
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) sum += i;
        /*
        O código está medindo o tempo que a JVM leva para executar um loop de
        1 milhão de iterações + a operação sum += i (0+1=1, 1+2=3, 3+3=6...)
         */
        Instant end = Instant.now();

        long ms = end.toEpochMilli() - init.toEpochMilli();
        /*
        toEpochMilli() = converte Instant em milissegundos desde 1970 (UTC)
         */
        System.out.println("Tempo: " + ms + "ms | soma= " + sum);

    }
}
