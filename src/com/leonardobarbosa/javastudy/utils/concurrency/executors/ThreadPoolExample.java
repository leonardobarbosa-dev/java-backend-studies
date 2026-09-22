package com.leonardobarbosa.javastudy.utils.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    /*
    ExecutorService -> gerencia um pool de threads reutilizáveis,
    em vez de criar uma Thread nova pra cada tarefa

    Vantagens sobre criar Thread manualmente:
    - reaproveita threads já criadas (criar thread tem custo)
    - controla o número máximo de threads simultâneas
    - centraliza o gerenciamento (submit, shutdown, etc.)

    Principais fábricas de Executors:
    newFixedThreadPool(n)  -> pool com número fixo de threads
    newCachedThreadPool()  -> cria threads sob demanda, reaproveita as ociosas
    newSingleThreadExecutor() -> só 1 thread, executa tarefas em sequência
     */

    public static void main(String[] args) throws InterruptedException {

        // newFixedThreadPool -> no máximo 2 threads executando ao mesmo tempo
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("executando tarefa " + taskId + " -> " + Thread.currentThread().getName());
            });
        }

        /*
        shutdown() -> não aceita novas tarefas, mas deixa as já
        submetidas terminarem normalmente

        awaitTermination() -> espera até o pool terminar (ou até o timeout)
         */
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("pool fixo encerrado");

        System.out.println("---");

        /*
        try-with-resources -> desde o Java 19, ExecutorService implementa
        AutoCloseable, então o close() é chamado automaticamente ao sair
        do bloco, mesmo se ocorrer exceção

        close() faz, por baixo, o equivalente a:
        shutdown();
        if (!awaitTermination(...)) shutdownNow();

        Vantagem: não precisa chamar shutdown()/awaitTermination()
        manualmente, nem tratar exceção -> close() não lança checked exception
         */
        try (ExecutorService singleExecutor = Executors.newSingleThreadExecutor()) {
            for (int i = 1; i <= 3; i++) {
                int taskId = i;
                singleExecutor.submit(() -> System.out.println("tarefa " + taskId + " -> " + Thread.currentThread().getName()));
            }
        }   // singleExecutor.close() chamado automaticamente aqui
    }
}