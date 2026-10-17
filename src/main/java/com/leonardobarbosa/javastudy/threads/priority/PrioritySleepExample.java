package com.leonardobarbosa.javastudy.threads.priority;

public class PrioritySleepExample {
    public static void main(String[] args) throws InterruptedException {

        /*
        Prioridade -> sugestão pro escalonador do SO sobre qual thread
        deve rodar primeiro, quando várias estão prontas ao mesmo tempo

        - Não é garantia -> o SO decide de fato
        - valores vão de MIN_PRIORITY (1) até MAX_PRIORITY (10)
        - padrão é NORM_PRIORITY (5)

        sleep() -> pausa a thread atual por um tempo determinado (em ms)
        - lança InterruptedException (checked) -> precisa tratar ou propagar
        - não libera nenhum lock que a thread esteja segurando
         */

        Thread low = new Thread(() -> System.out.println("baixa prioridade"));
        Thread high = new Thread(() -> System.out.println("alta prioridade"));

        low.setPriority(Thread.MIN_PRIORITY);    // 1
        high.setPriority(Thread.MAX_PRIORITY);   // 10

        System.out.println("prioridade low  -> " + low.getPriority());
        System.out.println("prioridade high -> " + high.getPriority());
        System.out.println("prioridade main -> " + Thread.currentThread().getPriority());   // padrão: 5

        low.start();
        high.start();

        // sleep() -> pausa a thread principal por 500ms antes de continuar
        System.out.println("main vai dormir...");
        Thread.sleep(500);
        System.out.println("main acordou");
    }
}