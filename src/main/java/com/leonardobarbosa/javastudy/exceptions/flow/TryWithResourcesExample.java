package com.leonardobarbosa.javastudy.exceptions.flow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {

        /*
        O try with resources gerencia recursos automaticamente.

        O recurso declarado entre parênteses
        é fechado automaticamente ao final do bloco try.

        Funciona apenas com objetos que implementam:
        - AutoCloseable
        - Closeable

        Uso comum:
        - arquivos - streams - conexões - sockets

        Sempre que possível, prefira try-with-resources
        ao fechamento manual utilizando finally.
         */

        readFileTryWithResources();
    }



    /**
     * Com o uso do try with resources
     */
    static void readFileTryWithResources() {

        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line = br.readLine();
            System.out.println("Conteúdo: " + line);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Sem o try with resources
     */
    static void readFile() {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("file.txt"));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
