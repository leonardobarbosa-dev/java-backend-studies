package com.leonardobarbosa.javastudy.utils.concurrency.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AllOfAnyOfExample {

    /*
    allOf(futures...) -> espera todos os CompletableFuture terminarem
    - retorna CompletableFuture<Void> -> não devolve os resultados direto,
      só sinaliza que todos terminaram (resultados pegos com join() de cada um)

    anyOf(futures...) -> espera o primeiro CompletableFuture que terminar
    - retorna CompletableFuture<Object> -> o resultado do que terminou primeiro
    - os outros continuam rodando, mas o resultado deles é ignorado aqui
     */

    public static void main(String[] args) {

        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> process(2));
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> process(4));
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> process(6));

        // allOf -> espera as 3 terminarem
        CompletableFuture<Void> all = CompletableFuture.allOf(task1, task2, task3);
        all.join();

        System.out.println("todas terminaram -> " + task1.join() + ", " + task2.join() + ", " + task3.join());

        // reaproveitando o padrão de Streams para pegar os resultados depois do allOf
        List<CompletableFuture<Integer>> futures = List.of(
                CompletableFuture.supplyAsync(() -> process(1)),
                CompletableFuture.supplyAsync(() -> process(3)),
                CompletableFuture.supplyAsync(() -> process(5))
        );

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        List<Integer> results = futures.stream()
                .map(CompletableFuture::join)
                .toList();
        System.out.println("resultados -> " + results);

        // anyOf -> espera só o primeiro terminar
        CompletableFuture<Integer> fast = CompletableFuture.supplyAsync(() -> process(1));
        CompletableFuture<Integer> slow = CompletableFuture.supplyAsync(() -> process(5));

        CompletableFuture<Object> any = CompletableFuture.anyOf(fast, slow);
        System.out.println("Primeiro a terminar -> " + any.join());
        System.out.println("Finalizado? -> " + any.isDone());   // sempre true -> any representa só "o primeiro que terminou"

        /*
        anyOf não cancela as outras tarefas -> "slow" continua rodando
        em segundo plano mesmo depois do anyOf já ter retornado

        o programa encerra mesmo assim, porque a thread da "slow" é daemon
        -> a JVM não espera threads daemon terminarem, só as não-daemon
         */
    }

    private static int process(int seconds) {
        sleep(seconds);
        System.out.println("terminou após " + seconds + "s");
        return seconds * 10;
    }

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}