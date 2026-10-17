package com.leonardobarbosa.javastudy.utils.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ChainingExample {

    /*
    Encadeando chamadas -> transformar o resultado de um CompletableFuture
    sem precisar chamar join() no meio do caminho

    thenApply(Function)  -> transforma o resultado em outro valor,
                            retorna um novo CompletableFuture com esse valor

    thenAccept(Consumer) -> usa o resultado para fazer algo (ex: imprimir,
                            salvar), não retorna nenhum valor

    thenRun(Runnable)    -> executa uma ação depois que a etapa anterior
                            terminou, sem acessar o resultado dela

    Cada um tem uma versão "Async" (thenApplyAsync, thenAcceptAsync,
    thenRunAsync) que roda em outra thread do pool, em vez de
    continuar na mesma thread que completou a etapa anterior
     */

    public static void main(String[] args) {

        // thenApply -> encadeia transformações, uma depois da outra
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(number -> number * 2)
                .thenApply(number -> number + 5)
                .thenApply(number -> "resultado final -> " + number);

        System.out.println(future.join());

        // thenAccept -> consome o resultado, sem retornar nada (Consumer)
        CompletableFuture<Void> consumed = CompletableFuture.supplyAsync(() -> "Death Note")
                .thenAccept(name -> System.out.println("consumindo -> " + name));

        consumed.join();

        // thenRun -> executa algo depois, sem acessar o resultado
        CompletableFuture<Void> ran = CompletableFuture.supplyAsync(() -> 100)
                .thenRun(() -> System.out.println("terminou, não importa qual foi o resultado"));

        ran.join();

        /*
        thenApplyAsync -> a próxima etapa roda em outra thread do pool,
        não necessariamente a mesma que executou a etapa anterior
         */
        CompletableFuture<Integer> asyncChain = CompletableFuture.supplyAsync(() -> {
            System.out.println("primeira etapa -> " + Thread.currentThread().getName());
            return 5;
        }).thenApplyAsync(number -> {
            System.out.println("segunda etapa -> " + Thread.currentThread().getName());
            return number * 10;
        });

        System.out.println("resultado -> " + asyncChain.join());
    }
}