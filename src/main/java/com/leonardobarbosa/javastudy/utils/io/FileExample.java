package com.leonardobarbosa.javastudy.utils.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) {

        /*
        java.io.File    -> I/O Input/Output

        - representa caminho de arquivos e diretórios
        - não lê nem escreve conteúdo
        - apenas manipula caminhos e metadados

        - verifica se o arquivo existe, se é um
        diretório ou se pode ser lido ou escrito

        - cria diretórios e arquivos vazios,
        além de excluí-los

        - lista o conteúdo de pastas
         */

        // Caminho relativo
        File file = new File("file.txt");
//        File file = new File("/home/leonardo/file.txt");  // Exemplo de caminho absoluto
        try {
            boolean isCreated = file.createNewFile();   // Cria apenas se o arquivo ainda não existir

            System.out.println("Created: " + isCreated);
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());

            System.out.println("isFile: " + file.isFile());
            System.out.println("isDirectory: " + file.isDirectory());

            System.out.println("Length: " + file.length());
            System.out.println("isHidden: " + file.isHidden());
            System.out.println("Last Modified: " + new Date(file.lastModified()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.exists()) {
            boolean isDeleted = file.delete();
            System.out.println("Deleated: " + isDeleted);
        }
    }
}
