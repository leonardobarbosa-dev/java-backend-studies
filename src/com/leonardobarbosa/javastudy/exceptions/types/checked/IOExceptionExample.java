package com.leonardobarbosa.javastudy.exceptions.types.checked;

import java.io.FileReader;
import java.io.IOException;

public class IOExceptionExample {
    public static void main(String[] args) {

        /*
        Tratamento com try/catch

        Ao capturar a exception:
        - a exigêngia do compilador é atendida
        - o programa pode continuar executando
        - é possível registrar ou recuperar o erro
         */

        try {
            FileReader fileReader = new FileReader("text.txt");
            fileReader.read();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
