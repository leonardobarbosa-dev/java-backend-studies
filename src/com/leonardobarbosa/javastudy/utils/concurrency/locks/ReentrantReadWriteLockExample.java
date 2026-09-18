package com.leonardobarbosa.javastudy.utils.concurrency.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Cache {
    private String value = "valor inicial";

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public String read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " -> lendo: " + value);
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(String newValue) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " -> escrevendo: " + newValue);
            value = newValue;
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockExample {
    public static void main(String[] args) throws InterruptedException {

        /*
        ReentrantReadWriteLock -> separa o lock em dois: leitura e escrita

        readLock()  -> várias threads podem ler ao mesmo tempo, sem bloquear
                   umas às outras (leitura não modifica o dado)

        writeLock() -> só uma thread por vez pode escrever, e nenhuma
                   consegue ler enquanto alguém está escrevendo

        Útil quando leituras são muito mais frequentes que escritas
        - com ReentrantLock comum, toda leitura bloquearia as outras também,
        mesmo sem necessidade
         */

        Cache cache = new Cache();

        // várias threads lendo ao mesmo tempo -> nenhuma bloqueia a outra
        Runnable readTask = cache::read;

        Thread reader1 = new Thread(readTask, "reader-1");
        Thread reader2 = new Thread(readTask, "reader-2");
        Thread reader3 = new Thread(readTask, "reader-3");

        reader1.start();
        reader2.start();
        reader3.start();
        reader1.join();
        reader2.join();
        reader3.join();

        Thread.sleep(2000);
        System.out.println("---");

        // escrita bloqueia leituras até terminar
        Thread writer = new Thread(() -> cache.write("valor atualizado"), "writer");
        Thread readerAfter = new Thread(cache::read, "reader-after");

        writer.start();
        writer.join();
        readerAfter.start();
        readerAfter.join();

        System.out.println(Thread.currentThread().getName() + " -> finalizado!");
    }
}