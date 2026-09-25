package com.leonardobarbosa.javastudy.utils.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GetAndJoinExample {

    /*
    CompletableFuture -> representa o resultado de uma tarefa que pode ser executada
    de forma assíncrona.

    Diferente do Future tradicional, o CompletableFuture oferece recursos para
    criar, combinar e encadear tarefas assíncronas.

    - supplyAsync() inicia uma tarefa assíncrona que retorna um resultado.
    - get() e join() podem ser utilizados para esperar a conclusão da tarefa e
      obter seu resultado.

    A principal diferença entre get() e join() está no tratamento das exceções:
    - get() pode lançar exceções verificadas (InterruptedException e ExecutionException)
    - join() lança exceções não verificadas (CancellationException e CompletionException)

    Neste exemplo, também são executadas várias tarefas simultaneamente para
    observar o funcionamento do CompletableFuture com diferentes threads.
    */

    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executando tarefa assíncrona...");
            sleep(2);

            return 10;
        });

        sleep(1);
        System.out.println("Main continua executando...");

        /*
        get() espera o resultado da tarefa assíncrona.
        Como vem da interface Future, pode lançar exceções verificadas.
         */
        Integer resultGet;
        try {
            resultGet = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Resultado com get(): " + resultGet);
        System.out.println("-------");


        CompletableFuture<Integer> futureJoin = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executando segunda tarefa assíncrona...");
            sleep(2);

            return 20;
        });

        sleep(1);
        System.out.println("Main continua executando novamente...");

        /*
        join() também espera o resultado da tarefa.
        A principal diferença é que não exige tratamento de
        InterruptedException e ExecutionException.
         */
        Integer resultJoin = futureJoin.join();
        System.out.println("Resultado com join(): " + resultJoin);

        /*
        Várias tarefas independentes podem ser executadas
        simultaneamente por diferentes threads.
         */
        long start = System.currentTimeMillis();

        /*
        Todas as 4 tarefas são criadas (e já começam a rodar)
        antes de qualquer join(). Se o join() de cada uma fosse chamado
        logo após sua criação, as tarefas rodariam sequencialmente,
        uma esperando a outra terminar -> o tempo total seria ~8s
        em vez dos ~2s que o teste confirma.
         */
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> process(2));
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> process(4));
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> process(6));
        CompletableFuture<Integer> task4 = CompletableFuture.supplyAsync(() -> process(8));

        // join() espera cada tafera terminar e retorna o resultado
        Integer resultTask1 = task1.join();
        Integer resultTask2 = task2.join();
        Integer resultTask3 = task3.join();
        Integer resultTask4 = task4.join();

        System.out.println("Resultado 1: " + resultTask1);
        System.out.println("Resultado 2: " + resultTask2);
        System.out.println("Resultado 3: " + resultTask3);
        System.out.println("Resultado 4: " + resultTask4);

        long end = System.currentTimeMillis();
        System.out.println("Tempo gasto -> " + (end - start) + "ms");
    }

    private static int process(int number) {
        System.out.printf("Processando número: %d na Thread: %s%n", number, Thread.currentThread().getName());
        sleep(2);

        return number * 10;
    }

    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}