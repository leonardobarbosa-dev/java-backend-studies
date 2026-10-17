package com.leonardobarbosa.javastudy.threads.yieldjoin;

public class YieldJoinExample {
    public static void main(String[] args) throws InterruptedException {

        /*
        yield() -> sugere ao escalonador que a thread atual pode ceder
        a vez para outras threads de mesma prioridade
        - assim como prioridade, é apenas uma sugestão -> o SO pode ignorar

        join() -> faz a thread atual esperar a outra thread terminar
        - diferente de sleep(), que pausa por tempo fixo
        - join() pausa até a thread referenciada finalizar (run() terminar)
         */

        Thread yielding = new Thread(() -> {
           for (int i = 1; i <= 3; i++) {
               System.out.println("yielding -> " + i);
               Thread.yield();  // cede a vez, mas sem garantia
           }
        });

        yielding.start();
        yielding.join();    // main espera "yielding"terminar antes de continuar
        System.out.println("yielding terminou, main continua...");

        /*
        join() sem argumentos -> espera indefinidamente
        join(ms) -> espera no máximo o tempo informado
         */

        Thread slow = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("slow terminou");
        });

        slow.start();
        slow.join(100);     // espera só 100ms, mesmo a thread levando 500ms
        System.out.println("main não esperou slow terminar -> continua");
    }
}
