package com.leonardobarbosa.javastudy.jdbc.crud.test;

import com.leonardobarbosa.javastudy.jdbc.crud.service.PublisherService;

import java.util.Scanner;

public class PublisherCrudTest {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            int operation;
            publisherMenu();

            operation = Integer.parseInt(scanner.nextLine());
            if (operation == 0) {
                System.out.println("Saindo...");
                break;
            }

            PublisherService.buildMenu(operation, scanner);
        }
    }

    private static void publisherMenu() {

        System.out.println("Digite o número da operação desejada:");
        System.out.println("1. Busca por nome ");
        System.out.println("0. Sair");
    }
}
