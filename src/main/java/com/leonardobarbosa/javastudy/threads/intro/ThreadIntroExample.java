package com.leonardobarbosa.javastudy.threads.intro;

public class ThreadIntroExample {
    public static void main(String[] args) {

        /*
        Thread -> permite executar código de forma concorrente,
        em paralelo com o restante do programa

        Duas formas de criar uma Thread:
        1. Estender a classe Thread e sobrescrever run()
        2. Implementar Runnable e passar pro construtor de Thread
           - preferível: Java só permite herdar de uma classe,
             então implementar Runnable deixa livre pra herdar outra coisa
         */

        System.out.println("Thread principal -> " + Thread.currentThread().getName());

        // Forma 1 -> extendendo Thread
        Thread t0 = new MyThread();
        t0.start();
        /*
        start() -> inicia a nova thread (nunca chamar run() direto)

        chamar run() direto executaria o código na mesma thread atual
        (sem criar thread nova nenhuma),sem nenhum ganho de concorrência.

        start() é quem de fato pede pra JVM criar uma nova thread do sistema operacional e agendar a execução.
         */

        // Forma 2 -> implementando Runnable
        Runnable runnable = () -> System.out.println("Rodando em -> " + Thread.currentThread().getName());
        Thread t1 = new Thread(runnable);
        t1.start();

        // A ordem de saída não é garantida
        System.out.println("Thread principal continua -> " + Thread.currentThread().getName());
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Rodando em -> " + Thread.currentThread().getName());
        }
    }
}
