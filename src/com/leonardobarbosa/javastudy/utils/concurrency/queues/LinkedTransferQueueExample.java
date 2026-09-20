package com.leonardobarbosa.javastudy.utils.concurrency.queues;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueExample {

    /*
    TransferQueue -> extensão de BlockingQueue com um recurso a mais:
    transfer()

    LinkedTransferQueue -> implementação baseada em lista encadeada,
    sem capacidade fixa (cresce conforme necessário)

    transfer(item) -> só retorna quando alguém consumir o item
    - diferente de put(), que só espera se a fila estiver cheia
    - transfer() sempre espera até um take()/poll() pegar aquele item específico
    - entrega "de mão em mão", sem o item ficar "esperando" na fila
     */

    public static void main(String[] args) throws InterruptedException {

        TransferQueue<String> queue = new LinkedTransferQueue<>();

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(500);   // consumer demora pra aparecer
                String item = queue.take();
                System.out.println("consumido -> " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer = new Thread(() -> {
            try {
                System.out.println("tentando transferir...");
                queue.transfer("Death Note");   // bloqueia até o consumer pegar

                Thread.sleep(1000);
                /*
                atraso de propósito, só para garantir a ordem de exibição
                no console -> transfer() já garante a entrega antes disso,
                não a ordem dos prints das duas threads depois
                 */
                System.out.println("transferido com sucesso!");
                /*
                transfer() garante que o item já foi entregue ao consumer
                (a troca aconteceu), mas não garante a ordem dos prints
                depois disso -> as duas threads seguem independentes,
                cada uma imprimindo por conta própria. Por isso essa
                linha pode aparecer antes ou depois do "consumido"
                 */
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();
        consumer.join();
        producer.join();

        /*
        tryTransfer() -> versão que não bloqueia
        - retorna true se já havia alguém esperando pra consumir
        - retorna false se não houver ninguém, sem esperar
         */
        TransferQueue<String> queueNoConsumer = new LinkedTransferQueue<>();
        boolean transferred = queueNoConsumer.tryTransfer("Naruto");
        System.out.println("tryTransfer() sem consumer esperando -> " + transferred);

        // hasWaitingConsumer() -> checa se existe alguém esperando por um item
        System.out.println("hasWaitingConsumer() -> " + queueNoConsumer.hasWaitingConsumer());
    }
}