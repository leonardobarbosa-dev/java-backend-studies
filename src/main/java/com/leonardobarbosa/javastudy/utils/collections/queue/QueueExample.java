package com.leonardobarbosa.javastudy.utils.collections.queue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

class Manga implements Comparable<Manga> {
	private final Long id;
	private final String name;
	private final double price;

    public Manga(String name, double price) {
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Manga o) {
        return Double.compare(o.price, this.price); // invertido -> o.price vem primeiro para ordenar do maior para o menor
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class QueueExample {
    public static void main(String[] args) {

        /*
        Queue -> fila, segue o princípio FIFO (First In, First Out)
        - o primeiro a entrar é o primeiro a sair
        LinkedList implementa Queue e é a implementação mais comum

        offer() -> adiciona no final da fila (retorna false se não couber, nunca lança exceção)
        poll()  -> remove e retorna o primeiro elemento (retorna null se vazia)
        peek()  -> consulta o primeiro elemento SEM remover (retorna null se vazia)
         */

        Queue<String> queue = new LinkedList<>();

        queue.offer("primeiro");
        queue.offer("segundo");
        queue.offer("terceiro");

        System.out.println(queue);  // consulta sem remover
        System.out.println(queue.poll());   // remove o primeiro
        System.out.println("Após o poll() -> " + queue);
        System.out.println();

        /*
        PriorityQueue -> fila com prioridade, não segue FIFO
        - o elemento com Maior valor (pelo compareTo ou Comparator) sempre sai primeiro
        - internamente organizada como heap, não como uma lista ordenada
        - poll() sempre retorna o maior elemento
         */

        Queue<Manga> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Manga("pokemon", 19.90));
        priorityQueue.offer(new Manga("Bleach", 29.90));
        priorityQueue.offer(new Manga("Death Note", 14.90));
        priorityQueue.offer(new Manga("Naruto", 17.90));

        System.out.println("peak() -> " + priorityQueue.peek());   // maior preço, sem remover

        System.out.println("poll() do maior para o menor:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());   // sempre sai o maior preço
        }
    }
}
