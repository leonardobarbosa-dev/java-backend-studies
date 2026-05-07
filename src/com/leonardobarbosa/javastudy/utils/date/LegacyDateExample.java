package com.leonardobarbosa.javastudy.utils.date;

import java.util.Date;

public class LegacyDateExample {
    public static void main(String[] args) {

        /**
         * java.util.Date — A API ORIGINAL (pré Java 8)
         * - Criada no Java 1.0, cheia de problemas de design
         * - Mutável: qualquer código pode alterar o objeto → difícil de proteger
         * - Meses baseados em 0 (janeiro = 0, dezembro = 11) → confuso
         * - A maioria dos métodos estão (@Deprecated)
         * - Não representa "só data" nem "só hora" → sempre carrega os dois juntos
         * - Não tem suporte a fuso horário adequado
         *
         * Encontrado em código legado, bibliotecas antigas e APIs de terceiros.
         * Conhecer os problemas justifica o java.time.
         *
         * USE HOJE: java.time.* (Java 8+)
         */

        // Cria um Date com o momento atual (ms desde 01/01/1970 UTC — "epoch")
        Date now = new Date();
        System.out.println(now); // formato pouco legível: <DiaDaSemana> <Mês> <DiaNumero> <Hora> BRT <Ano>

        // getTime() → retorna os milissegundos desde o epoch (Unix timestamp)
        System.out.println("Timestamp ms: " + now.getTime());

        // Criando a partir de milissegundos
        Date msDate = new Date(1_0000_000_000L);
        System.out.println(msDate); // Sun Apr 26 14:46:40 BRT 1970

        // Comparações
        Date dateOne = new Date(1000);
        Date dateTwo = new Date(9000);

        System.out.println(dateOne.before(dateTwo)); // true
        System.out.println(dateTwo.after(dateOne));  // true
        System.out.println(dateOne.compareTo(dateTwo)); // -1 → dateOne < dateTwo

        // PROBLEMA: Date é mutável — qualquer um pode alterar de fora
        Date date = new Date();
        date.setTime(0); // altera → estado corrompido facilmente
        System.out.println(date); // Wed Dec 31 21:00:00 BRT 1969

        System.out.println(new Date(2026, 0, 1));

        /*
        construtores @Deprecated (não use, apenas para entender o legado)
        new Date(2026, 0, 1) → mês 0 = janeiro, mas ANO é relativo a 1900
        ou seja, 2026 significa o ano 3926. (muito complicado)
         */
    }
}
