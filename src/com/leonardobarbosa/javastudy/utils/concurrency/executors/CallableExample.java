package com.leonardobarbosa.javastudy.utils.concurrency.executors;

import com.sun.security.jgss.GSSUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    /*
    Callable<T> -> interface funcional parecida com Runnable, mas com
    duas diferenças importantes:

    Runnable.run()     -> não retorna nada (void), não pode lançar checked exception
    Callable<T>.call() -> retorna um valor (T), pode lançar checked exception

    Usado com ExecutorService.submit(), que devolve um Future<T> com
    o resultado do call()
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            // Callable como lambda -> só precisa implementar call()
            Callable<Integer> sumTask = () -> {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            };

            Future<Integer> future = executor.submit(sumTask);
            System.out.println("sum -> " + future.get());   // bloqueia até o call() terminar


            // Callable pode lançar exceção checked diretamente -> Runnable não pode
            Callable<String> riskyTask = () -> {
                if (true) {
                    throw new Exception("algo deu errado dentro do Callable");
                }
                return "nunca chega aqui";
            };

            Future<String> riskyFuture = executor.submit(riskyTask);
            try {
                riskyFuture.get();
            } catch (ExecutionException e) {
                System.out.println("erro capturado -> " + e.getCause().getMessage());
            }

            // várias tarefas Callable ao mesmo tempo
            Callable<Integer> doubleTask = () -> {
                Thread.sleep(100);
                return 2 * 2;
            };
            Callable<Integer> tripleTask = () -> {
                Thread.sleep(100);
                return 3 * 3;
            };

            Future<Integer> f1 = executor.submit(doubleTask);
            Future<Integer> f2 = executor.submit(tripleTask);

            System.out.println("resultado 1 -> " + f1.get());
            System.out.println("resultado 2 -> " + f2.get());
        }
    }
}