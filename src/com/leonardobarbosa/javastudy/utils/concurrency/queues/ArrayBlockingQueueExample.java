package com.leonardobarbosa.javastudy.utils.concurrency.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {

    /*
    BlockingQueue -> fila thread-safe que bloqueia a thread quando
    a operação não pode ser feita imediatamente

    ArrayBlockingQueue -> implementação com capacidade fixa (definida
    na criação)

    put()  -> adiciona; se a fila estiver cheia, bloqueia até ter espaço
    take() -> remove; se a fila estiver vazia, bloqueia até ter algo

    Substitui o padrão manual de wait()/notify() (visto em Threads)
    para o cenário clássico de produtor/consumidor
     */

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);   // capacidade fixa: 3

        Thread producer = new Thread(() -> {
            String[] items = {"Naruto", "Death Note", "Pokemon", "Dragon Ball"};
            for (String item : items) {
                try {
                    queue.put(item);   // bloqueia aqui se a fila já tiver 3 itens
                    System.out.println("produzido -> " + item);   // só imprime depois que o put() de fato entrou
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(300);   // consumidor mais lento que o produtor, de propósito
                    String item = queue.take();   // bloqueia se a fila estiver vazia
                    System.out.println("consumido -> " + item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

        System.out.println(queue.size());

        /*
        offer()/poll() -> versões que não bloqueiam
        - offer() -> se tiver espaço: coloca e retorna true | se estiver cheia: desiste e retorna false (sem travar nada)
        - poll() -> se tiver algo: tira e devolve | se estiver vazia: desiste e retorna null
         */

        BlockingQueue<String> smallQueue = new ArrayBlockingQueue<>(1);
        smallQueue.offer("primeiro");
        boolean added = smallQueue.offer("segundo");   // fila já cheia
        System.out.println("offer() em fila cheia -> " + added);

        String polled = smallQueue.poll();
        System.out.println("poll() -> " + polled);

        String polledEmpty = smallQueue.poll();   // fila vazia
        System.out.println("poll() em fila vazia -> " + polledEmpty);
    }
}