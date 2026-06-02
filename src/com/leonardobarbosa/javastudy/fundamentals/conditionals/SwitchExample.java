package com.leonardobarbosa.javastudy.fundamentals.conditionals;

import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Switch
        System.out.print("\nEscolha um dia da semana de 1 a 7: ");
        int day = sc.nextInt();

        // char, int, byte, short, enum, String
        switch (day) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("Opção inválida! Digite um número de 1 á 7...");
                break;
        }

        // Outro exemplo do uso de switch
        System.out.print("\nEscolha um dia da semana de 1 á 7:");
        int dayOfWeek = sc.nextInt();

        switch (dayOfWeek) {
            case 1:
            case 7:
                System.out.println("Final de semana!");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia útil!");
                break;
            default:
                System.out.println("Opção inválida!");
        }



        /*
            Não existe um metodo nextChar() na classe Scanner. O procedimento padrão é ler uma String: .next()

            .charAt(0) = .next().charAt(0); = pega o primeiro caractere

            .toUpperCase() = quando as comparações estão em maiúsculo (M)/(F), ignora se o usuário digitar minúsculo
            .toLowerCase() = quando as comparações estão em minúsculo (m)/(f), ignora se o usuário digitar maiúsculo
         */

        System.out.print("\nQual o seu sexo: (M) masculino (F) feminino:");
        char sex = sc.next().toUpperCase().charAt(0);

        switch (sex) {
            case 'M':
                System.out.println("Masculino");
                break;
            case 'F':
                System.out.println("Feminino");
                break;
            default:
                System.out.println("Opção inválida! Digite apenas (M) ou (F)");
        }

        sc.close();
    }
}
