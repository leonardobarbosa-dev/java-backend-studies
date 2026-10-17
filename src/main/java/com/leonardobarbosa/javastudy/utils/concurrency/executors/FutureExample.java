package com.leonardobarbosa.javastudy.utils.concurrency.executors;

import java.util.concurrent.*;

public class FutureExample {

    /*
    Future<T> -> representa o resultado de uma tarefa assíncrona,
    que ainda pode não ter terminado

    Já usado nas aulas anteriores via get(). Aqui, os outros métodos:

    isDone()      -> a tarefa já terminou (com sucesso, erro ou cancelamento)?
    isCancelled() -> a tarefa foi cancelada?
    cancel()      -> tenta cancelar a tarefa
    get(timeout)  -> espera só até um limite de tempo, lança TimeoutException se estourar
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            Callable<Integer> slowTask = () -> {
                Thread.sleep(500);
                return 42;
            };

            Future<Integer> future = executor.submit(slowTask);

            System.out.println("isDone() logo após submit() -> " + future.isDone());   // ainda rodando

            Thread.sleep(600);   // espera a tarefa terminar de verdade
            System.out.println("isDone() após esperar -> " + future.isDone());
            System.out.println("get() -> " + future.get());

            /*
            get(timeout) -> não espera indefinidamente, desiste depois
            do tempo informado, lançando TimeoutException
             */
            Future<Integer> anotherFuture = executor.submit(slowTask);   // demora 500ms
            try {
                anotherFuture.get(100, TimeUnit.MILLISECONDS);   // só espera 100ms
            } catch (TimeoutException e) {
                System.out.println("get(timeout) -> estourou o tempo, tarefa ainda rodando");
            }

            /*
            cancel(true) -> tenta interromper a tarefa, mesmo já em execução
            cancel(false) -> só cancela se ainda não tiver começado a rodar
             */
            Future<Integer> toCancel = executor.submit(slowTask);
            boolean cancelled = toCancel.cancel(true);
            System.out.println("cancel(true) -> conseguiu cancelar? " + cancelled);
            System.out.println("isCancelled() -> " + toCancel.isCancelled());

            try {
                toCancel.get();   // tentar pegar o resultado de uma tarefa cancelada
            } catch (CancellationException e) {
                System.out.println("get() em tarefa cancelada -> " + e.getClass().getSimpleName());
            }
        }
    }
}