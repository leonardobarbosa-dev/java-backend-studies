package com.leonardobarbosa.javastudy.utils.collections.map;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Client {

    private final Long id;
    private final String name;

    public Client(String name) {
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Book {

    private final Long id;
    private final String name;

    public Book(String name) {
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getName() {
        return name;
    }
}
public class MapWithListExample {
    public static void main(String[] args) {

    Client clientOne = new Client("Juvenal");
    Client clientTwo = new Client("Franciscreuzo");

    Book bookOne = new Book("God of war");
    Book bookTwo = new Book("Resident Evil");
    Book bookThree = new Book("Thor");
    Book bookFour = new Book("Vikings");

    List<Book> booksClientOne = List.of(bookFour, bookTwo);
    List<Book> booksClientTwo = List.of(bookOne, bookThree);

    Map<Client, List<Book>> mapList = new HashMap<>();
    mapList.put(clientOne, booksClientOne);
    mapList.put(clientTwo, booksClientTwo);

    for (Map.Entry<Client, List<Book>> entry : mapList.entrySet()) {
        System.out.println("Cliente: " + entry.getKey().getName());
        for (Book book : entry.getValue()) {
            System.out.println("   Book: " + book.getName());
        }
    }

    }
}
