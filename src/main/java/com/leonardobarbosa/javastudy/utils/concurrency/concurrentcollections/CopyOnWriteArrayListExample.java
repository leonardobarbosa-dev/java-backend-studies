package com.leonardobarbosa.javastudy.utils.concurrency.concurrentcollections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    /*
    CopyOnWriteArrayList -> implementação de List thread-safe

    Estratégia: a cada escrita (add/remove/set), cria uma cópia
    completa do array interno, modifica a cópia, e troca a referência
    - leituras nunca são bloqueadas -> sempre leem uma versão "congelada"
      e consistente do array, mesmo que outra thread esteja escrevendo

    Ideal quando: muito mais leitura do que escrita
    - cada escrita é cara (copia o array inteiro)
    - leitura é extremamente rápida e nunca bloqueia
     */

    public static void main(String[] args) throws InterruptedException {

        // duas threads adicionando 5000 vezes cada -> esperado: 10000
        // (mesmo teste feito com ArrayList comum, que corrompia)

        List<String> names = new CopyOnWriteArrayList<>();
        Runnable addTask = () -> {
            for (int i = 0; i < 5000; i++) {
                names.add("Leon");
            }
        };

        Thread t1 = new Thread(addTask);
        Thread t2 = new Thread(addTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("CopyOnWriteArrayList size -> " + names.size() + " (esperado: 10000)");

        /*
        Iterator de CopyOnWriteArrayList não lança ConcurrentModificationException
        - ele itera sobre uma "foto" do array no momento em que iterator() foi chamado
        - mudanças feitas depois não aparecem nessa iteração em andamento
         */

        List<String> letters = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        for (String letter : letters) {
            System.out.println("iterando -> " + letter);
            letters.add("D");   // modifica durante a iteração -> não lança exceção
        }

        System.out.println("letters final -> " + letters);
    }
}