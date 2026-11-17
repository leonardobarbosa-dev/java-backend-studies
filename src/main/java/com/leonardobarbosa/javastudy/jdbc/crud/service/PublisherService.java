package com.leonardobarbosa.javastudy.jdbc.crud.service;


import com.leonardobarbosa.javastudy.jdbc.crud.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.crud.repository.PublisherRepository;

import java.util.List;
import java.util.Scanner;


public class PublisherService {

    public static void buildMenu(int operation, Scanner scanner) {

        switch (operation) {

            case 1:
                findByName(scanner);
                break;

            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }

    private static void findByName(Scanner scanner) {

        System.out.println("Escreva o nome para busca ou deixe vazio para listar todos: ");
        String nameSearch = scanner.nextLine();

        List<Publisher> byName = PublisherRepository.findByName(nameSearch);

        if (byName.isEmpty()) {
            System.out.println("Publisher não encontrado");
            return;
        }

        for (Publisher publisher: byName) {
            System.out.printf("[%d] - %s%n", publisher.getId(), publisher.getName());
        }
    }

}