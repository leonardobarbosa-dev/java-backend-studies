package com.leonardobarbosa.javastudy.utils.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    /*
    AtomicInteger -> classe da API de concorrência que permite
    incrementar/alterar um int de forma thread-safe, sem usar
    synchronized

    Por baixo, usa operações atômicas da CPU (compare-and-swap),
    mais rápidas que lock/synchronized em cenários de alta concorrência

    count++ não é atômico (ler, somar, gravar em 3 passos)
    incrementAndGet() É atômico (tudo em uma única operação indivisível)
     */

    static class Counter {
        private int count;

        /*
        increment() não é thread-safe -> count++ não é atômico

        A falha (resultado menor que o esperado) depende do hardware:
        em máquinas com múltiplos cores, as threads rodam de fato em
        paralelo, aumentando a chance de colisão -> a falha costuma
        aparecer de forma consistente.
        Em ambientes com poucos cores (ex: uma CI ou container limitado),
        o sistema operacional raramente alterna entre as threads no
        momento exato do count++, e o resultado pode sair certo
        mesmo sem nenhuma proteção -> não significa que o código é seguro.

        Para forçar a falha de forma confiável em qualquer hardware,
        separar o count++ em 3 passos e inserir Thread.yield() entre
        a leitura e a escrita, aumentando a chance do SO trocar de
        thread bem no meio da operação:

        int current = count;
        Thread.yield();
        count = current + 1;
         */
        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class AtomicCounter {
        private final AtomicInteger count = new AtomicInteger();

        public void increment() {
            count.incrementAndGet();   // thread-safe, sem synchronized
        }

        public int getCount() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // duas threads incrementando 50_000 vezes cada -> esperado: 100_000

        Counter counter = new Counter();
        Runnable incrementCounter = () -> {
            for (int i = 0; i < 50000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(incrementCounter);
        Thread t2 = new Thread(incrementCounter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter (não thread-safe) -> " + counter.getCount() + " (esperado: 100000)");

        AtomicCounter atomicCounter = new AtomicCounter();
        Runnable incrementAtomicCounter = () -> {
            for (int i = 0; i < 50000; i++) {
                atomicCounter.increment();
            }
        };

        Thread t3 = new Thread(incrementAtomicCounter);
        Thread t4 = new Thread(incrementAtomicCounter);
        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("AtomicCounter -> " + atomicCounter.getCount() + " (esperado: 100000)");

        // outras operações úteis do AtomicInteger
        AtomicInteger atomic = new AtomicInteger(10);
        System.out.println("get()            -> " + atomic.get());
        System.out.println("getAndIncrement()-> " + atomic.getAndIncrement());   // retorna o valor ANTES de incrementar
        System.out.println("incrementAndGet()-> " + atomic.incrementAndGet());   // retorna o valor DEPOIS de incrementar
        System.out.println("addAndGet(5)     -> " + atomic.addAndGet(5));
        System.out.println("compareAndSet()  -> " + atomic.compareAndSet(17, 100));   // só atualiza se o valor atual for 17
        System.out.println("get() final      -> " + atomic.get());
    }
}