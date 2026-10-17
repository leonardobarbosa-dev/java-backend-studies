package com.leonardobarbosa.javastudy.utils.concurrency.executors;

import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {

    /*
    ScheduledExecutorService -> extensão de ExecutorService que permite
    agendar tarefas para rodar depois de um tempo, ou repetidamente

    schedule()                -> executa uma vez, após um delay

    scheduleAtFixedRate()      -> conta a partir do início da execução anterior
                               -> se a tarefa for mais lenta que o período, a próxima
                                  começa imediatamente ao terminar, sem pausa nenhuma

    scheduleWithFixedDelay()   -> conta a partir do fim da execução anterior
                               -> sempre garante uma pausa real entre execuções,
                                  não importa quanto a tarefa demorou
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1)) {

            // schedule() -> roda uma única vez, após 2s
            System.out.println("agendando tarefa única...");
            ScheduledFuture<?> future = scheduler.schedule(
                    () -> System.out.println("executou após delay -> " + Thread.currentThread().getName()),
                    2,
                    TimeUnit.SECONDS
            );

            future.get();   // espera essa tarefa terminar antes de continuar
            System.out.println("---");

            /*
            scheduleAtFixedRate(tarefa, delayInicial, período, unidade)
            - dispara a cada "período", contado desde o início da execução anterior
            - se a tarefa demorar mais que o período, a próxima roda logo em seguida
             */
            System.out.println("agendando tarefa periódica (a cada 300ms)...");
            int[] count = {0};
            ScheduledFuture<?> periodic = scheduler.scheduleAtFixedRate(
                    () -> {
                        count[0]++;
                        System.out.println("execução periódica " + count[0] + " -> " + Thread.currentThread().getName());
                    },
                    0,
                    300,
                    TimeUnit.MILLISECONDS
            );

            Thread.sleep(1000);   // deixa rodar algumas vezes
            periodic.cancel(false);   // cancela o agendamento (false -> não interrompe se já estiver rodando)
            System.out.println("tarefa periódica cancelada");
        }   // close() encerra o scheduler automaticamente
    }
}