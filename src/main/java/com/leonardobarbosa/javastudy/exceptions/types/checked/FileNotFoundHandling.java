package com.leonardobarbosa.javastudy.exceptions.types.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundHandling {
    public static void main(String[] args) {

        /*
        Tratar uma exception específica:

        Boas práticas:
        - prefira capturar exceptions específicas
        - evite usar (Exception e) quando não for necessário

        Quanto mais específico o catch,
        mais claro fica o tratamento do erro
         */

        try {
            FileReader fileReader = new FileReader("text.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. " + e.getMessage());
        }
    }
}
