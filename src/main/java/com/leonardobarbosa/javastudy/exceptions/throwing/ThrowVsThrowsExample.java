package com.leonardobarbosa.javastudy.exceptions.throwing;

import java.io.File;
import java.io.FileNotFoundException;

public class ThrowVsThrowsExample {
    public static void main(String[] args) {

        /*
        THROW:
        - cria e lança uma exception
        - interrompe o fluxo imediatamente

        THROWS:
        - declara que o metodo pode lançar uma exception
        - transfere a responsabilidade para quem chamou o metodo

        throw = lançar
        throws = declarar
         */


        // 3. TRY/CATCH: Tenta executar o código e captura possíveis erros
        try {
            readFile("text.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Erro capturado no main! " + e.getMessage());
        }
    }

    // 1. THROWS: O metodo avisa que pode lançar uma FileNotFoundException
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        if (!file.exists()) {
            // 2. THROW: Lança a exceção explicitamente se o arquivo não existir
            throw new FileNotFoundException("throw new: Arquivo não encontrado.");
        }
        System.out.println("Arquivo encontrado.");
    }
}
