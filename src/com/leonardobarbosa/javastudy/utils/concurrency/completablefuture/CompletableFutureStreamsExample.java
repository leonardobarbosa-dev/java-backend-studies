package com.leonardobarbosa.javastudy.utils.concurrency.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureStreamsExample {

        /*
        CompletableFuture com Stream

        - Stream.map() transforma cada elemento em um CompletableFuture.
        - toList() executa a Stream e cria todos os CompletableFuture.
        - join() aguarda o resultado de cada tarefa.

        Fluxo:
        1. map() + toList() -> cria e inicia todas as tarefas
        2. map() + join() -> aguarda e coleta os resultados

        Importante:
        - Os dois passos são separados para que todas as tarefas
          sejam iniciadas antes de começar a aguardar os resultados.

        - Se join() fosse chamado dentro do mesmo map() que cria os futures,
          a stream processaria um elemento por vez -> voltaria a ser sequencial

        */

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2, 4, 6, 8);

        long start = System.currentTimeMillis();

        // passo 1 -> cria e inicia um CompletableFuture para cada número
        List<CompletableFuture<Integer>> futures = numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> process(number)))
                .toList();

        // passo 2 -> aguarda o resultado de cada tarefa
        List<Integer> results = futures.stream()
                .map(CompletableFuture::join)
                .toList();

        long end = System.currentTimeMillis();

        System.out.println("resultados -> " + results);
        System.out.println("Tempo gasto -> " + (end - start) + "ms");   // 2s em vez de 8s -> tarefas executadas de forma concorrente
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