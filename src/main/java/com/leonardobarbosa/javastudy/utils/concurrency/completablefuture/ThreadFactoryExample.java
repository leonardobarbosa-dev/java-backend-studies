package com.leonardobarbosa.javastudy.utils.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryExample {

    /*
    ThreadFactory -> cria as threads usadas por um Executor

    Por padrão, o CompletableFuture usa o ForkJoinPool comum da JVM,
    com nomes de thread genéricos (ex: ForkJoinPool.commonPool-worker-1)

    Com um ThreadFactory customizado, dá pra controlar:
    - nome da thread
    - se é daemon ou não
    - prioridade
    - qualquer outra configuração feita na criação

    Fluxo:
    1. criar um ThreadFactory customizado
    2. criar um Executor usando esse ThreadFactory
    3. passar esse Executor como segundo argumento do supplyAsync()
     */

    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger(1);

        ThreadFactory threadFactory = runnable -> {
            Thread thread = new Thread(runnable);
            thread.setName("minha-thread-" + counter.getAndIncrement());
            thread.setDaemon(true); // daemon -> não impede a JVM de encerrar o programa
            return thread;
        };

        Executor executor = Executors.newFixedThreadPool(2, threadFactory);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(
                () -> System.out.println("rodando em -> " + Thread.currentThread().getName()),
                executor
        );

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(
                () -> System.out.println("rodando em -> " + Thread.currentThread().getName()),
                executor
        );

        future1.join();
        future2.join();

        // checando se a thread é mesmo daemon
        CompletableFuture.runAsync(
                () -> System.out.println("é daemon? -> " + Thread.currentThread().isDaemon()),
                executor
        ).join();
    }
}