package com.leonardobarbosa.javastudy.threads.states;

public class ThreadStatesExample {
    public static void main(String[] args) throws InterruptedException {

        /*
        Estados de uma Thread (Thread.State):

        NEW           -> criada, mas start() ainda não foi chamado
        RUNNABLE      -> executando ou pronta pra executar (aguardando o SO agendar)
        TIMED_WAITING -> pausada por tempo determinado (ex: Thread.sleep())
        WAITING       -> pausada indefinidamente, aguardando outra thread
        TERMINATED    -> terminou a execução (run() finalizou)

        BLOCKED -> aguardando liberação de um lock (visto em sincronismo)
         */

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(200);   // TIMED_WAITING durante essa pausa
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("antes de start()   -> " + thread.getState());   // NEW

        thread.start();
        System.out.println("logo após start()  -> " + thread.getState());   // RUNNABLE (provavelmente)

        Thread.sleep(50);   // dá tempo da thread entrar no sleep(200)
        System.out.println("durante sleep()    -> " + thread.getState());   // TIMED_WAITING

        thread.join();   // espera a thread terminar
        System.out.println("após terminar      -> " + thread.getState());   // TERMINATED
    }
}