package com.leonardobarbosa.javastudy.utils.concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Message {
    private String content;
    private boolean available = false;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void send(String content) {
        lock.lock();
        try {
            this.content = content;
            this.available = true;
            System.out.println("send -> " + content);
            condition.signal();   // acorda quem estiver esperando em receive()
        } finally {
            lock.unlock();
        }
    }

    public String receive() {
        lock.lock();
        try {
            while (!available) {
                try {
                    condition.await();   // libera o lock e espera ser notificado
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            available = false;
            return content;
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionExample {
    public static void main(String[] args) throws InterruptedException {

        /*
        Condition -> equivalente ao wait()/notify() do synchronized,
        mas associado a um Lock explícito em vez de um objeto qualquer

        await()   -> equivale a wait()   -> libera o lock e espera ser notificado
        signal()  -> equivale a notify() -> acorda uma thread esperando nessa Condition

        Vantagem sobre wait()/notify(): um mesmo Lock pode ter várias
        Conditions -> permite acordar grupos diferentes de threads
        separadamente, algo que wait()/notify() não conseguem fazer sozinhos
        */

        Message message = new Message();

        Thread receiver = new Thread(() -> {
            System.out.println("receiver -> esperando mensagem...");
            String received = message.receive();
            System.out.println("receiver -> recebeu: " + received);
        });

        Thread sender = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            message.send("Olá, Condition!");
        });

        receiver.start();
        sender.start();
        receiver.join();
        sender.join();
    }
}