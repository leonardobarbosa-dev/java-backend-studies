package com.leonardobarbosa.javastudy.threads.synchronization;

public class DeadlockExample {
    public static void main(String[] args) throws InterruptedException {

        /*
        Deadlock -> duas threads ficam travadas para sempre, cada uma
        esperando um lock que a outra está segurando (espera circular)

        thread1: segura lockA, espera lockB
        thread2: segura lockB, espera lockA
        - nenhuma libera o que já tem -> nenhuma consegue continuar
        - Não é apenas "esperar" (isso é normal em concorrência),
          é (a espera ser mútua e simultânea que trava tudo)

        Esse exemplo trava de propósito por alguns segundos e depois
        o programa é interrompido, apenas para demonstrar o problema...
         */

        Object lockA = new Object();
        Object lockB = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread1 segurando lockA");
                sleep(100);
                System.out.println("Thread1 esperando lockB");
                synchronized (lockB) {
                    System.out.println("Thread1 conseguiu lockB");
                }
            }
        });

        Thread t2 = new Thread(() -> {
           synchronized (lockB) {
               System.out.println("Thread2 segurando lockB");
               sleep(100);
               System.out.println("Thread 2 esperando lockA");
               synchronized (lockA) {
                   System.out.println("Thread 2 conseguiu lockA");
               }
           }
        });

        t1.start();
        t2.start();

        // join(ms) -> espera um tempo determinado, se não terminal, é sinal de deadlock
        t1.join(3000);
        t2.join(3000);

        System.out.println("Thread1 viva ? -> " + t1.isAlive());
        System.out.println("Thread2 viva ? -> " + t2.isAlive());
        System.out.println("Se ambas estiverem vivas o deadlock foi confirmado");

        System.exit(0);     // força o encerramento, já que as threads travadas nunca terminam sozinhas...
    }

    private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
