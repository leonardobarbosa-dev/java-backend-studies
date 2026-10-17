package com.leonardobarbosa.javastudy.utils.date.instant;

import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {

        // Instant representa tempo absoluto (UTC epoch)
        Instant start = Instant.now();

        // Operação simples para benchmark
        long sum = 0;
        for (int i = 0; i < 100_000; i++) sum += i;

        Instant end = Instant.now();

        // Diferença em milissegundos
        System.out.println(end.toEpochMilli() - start.toEpochMilli());
        System.out.println(sum);
    }
}