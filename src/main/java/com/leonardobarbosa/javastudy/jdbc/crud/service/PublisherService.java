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

            case 2:
                delete(scanner);
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

    private static void delete(Scanner scanner) {

        System.out.println("Digite o id do publisher para deletar");
        int deleteID = Integer.parseInt(scanner.nextLine());

        System.out.println("Tem certeza que deseja deletar o id: " + deleteID);
        System.out.println("y/n");
        String choice = scanner.nextLine();

        if ("y".equalsIgnoreCase(choice)) {

            boolean deleted = PublisherRepository.delete(deleteID);

            if (deleted) {
                System.out.println("Publisher deletado com sucesso");
            } else {
                System.out.println("Nenhum publisher encontrado com o ID informado");
            }

        } else {
            System.out.println("Operação cancelada");
        }
    }

}