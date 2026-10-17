package com.leonardobarbosa.javastudy.utils.string.regex;

import java.util.Scanner;

public class RegexWithScannerExample {
    public static void main(String[] args) {

        /*
          Scanner divide texto em tokens.

          Delimitador padrão
          - espaço em branco

          useDelimiter()
          - aceita regex
         */

        // Delimitador padrão
        String text = "Java é muito verboso";
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        System.out.println();
        scanner.close();


        // Trocando delimitador por regex
        String message = "nome, idade, CPF, endereço,";
        scanner = new Scanner(message);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.println(scanner.next().trim());   // trim() remove espaços em branco
        }
        System.out.println();
        scanner.close();


        // Lendo tipos específicos
        String specific = "Java, Python, 3.14, 200, true, 27, false, 27.1";
        scanner = new Scanner(specific);
        scanner.useDelimiter(",\\s");    // Remove virgulas e espaços em branco
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                System.out.println("int: " + i);
            } else if (scanner.hasNextDouble()) {
                double d = scanner.nextDouble();
                System.out.println("double: " + d);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("boolean:  " + b);
            } else {
                System.out.println("String: " + scanner.next());
            }
        }
        scanner.close();
    }
}
