package com.leonardobarbosa.javastudy.utils.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    /*
    Lock -> interface que representa um bloqueio explícito, alternativa
    ao synchronized

    ReentrantLock -> implementação mais usada de Lock
    - "reentrante" -> a mesma thread pode adquirir o lock várias vezes
      sem travar a si mesma (precisa dar unlock() o mesmo número de vezes)

    Diferenças em relação ao synchronized:
    - lock()/unlock() são chamados manualmente -> mais controle, mais risco
      (esquecer o unlock() trava o programa para sempre)
    - tryLock() -> tenta adquirir sem bloquear, retorna false se não conseguir
    - permite tentar o lock com timeout
     */

    static class Counter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();   // finally garante que o lock é liberado mesmo se der exceção
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Runnable increment = () -> {
            for (int i = 0; i < 50000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter (ReentrantLock) -> " + counter.getCount() + " (esperado: 100000)");

        /*
        Reentrância -> a mesma thread pode chamar lock() de novo,
        mesmo já segurando o lock (útil em chamadas recursivas/aninhadas)
         */
        Lock lock = new ReentrantLock();
        lock.lock();

        try {
            System.out.println("primeira aquisição do lock");
            lock.lock();   // mesma thread, adquire de novo sem travar
            try {
                System.out.println("segunda aquisição do lock (reentrante)");
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();   // precisa dar unlock() 2x, uma para cada lock()
        }

        /*
        tryLock() -> tenta adquirir sem esperar; retorna imediatamente
        true (conseguiu) ou false (não conseguiu, já está em uso)
         */
        Lock tryLockDemo = new ReentrantLock();
        tryLockDemo.lock();   // main chama lock aqui

        Thread other = new Thread(() -> {
            boolean acquired = tryLockDemo.tryLock();   // outra thread tenta
            System.out.println("outra thread conseguiu o lock? -> " + acquired);
        });
        other.start();
        other.join();

        tryLockDemo.unlock();   // main libera aqui, só depois da thread other terminar
    }
}