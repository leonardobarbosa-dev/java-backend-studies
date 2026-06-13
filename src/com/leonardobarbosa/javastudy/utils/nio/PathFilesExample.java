package com.leonardobarbosa.javastudy.utils.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFilesExample {
    public static void main(String[] args) {

        /*
        Nio - Path, Paths e Files

        Path
        - representa o caminho de um arquivo ou diretório
        - substitui a classe File

        Paths
        - cria objetos Path

        Files
        - realiza operações no sistema de arquivos

        - criar arquivos e diretórios
        - verificar existência
        - copiar, mover e deletar
         */

        Path directory = Paths.get("DirectoryNIO");

        try {

            // Criar diretório
            if (Files.notExists(directory)) {
                Files.createDirectory(directory);
                System.out.println("Diretório criado");
            } else {
                System.out.println("Diretório já existe");
            }

            // Criar diretórios aninhados -> não lança exceção caso já exista
            Path nestedDirectory = Paths.get("DirectoryNIO/files/test");
            Files.createDirectories(nestedDirectory);

            // Criar arquivo dentro do diretório
            Path file = nestedDirectory.resolve("test.txt");
            // resolve() funciona como uma forma de juntar caminhos
            // pegue este caminho -> entre nele -> adicione este arquivo

            if (Files.notExists(file)) {
                Files.createFile(file);
                System.out.println("Arquivo criado");
            } else {
                System.out.println("Arquivo já existe");
            }

            // Informações do Path
            System.out.println("Arquivo: " + file.getFileName());
            System.out.println("Caminho absoluto: " + file.toAbsolutePath());
            System.out.println("Parente: " +  file.getParent());

            // Renomear arquivo
            Path source = file; // caminho original
            Path target = Paths.get("DirectoryNIO/files/test/file_renamed.txt");   // novo caminho com novo nome

            // Embora Files.move também sirva para mover arquivos,
            // se os diretórios de origem e destino forem os mesmos,
            // a operação funciona exatamente como uma renomeação.

            Files.move(source, target); // renomeia o arquivo
            System.out.println("Arquivo renomeado");


            // Deletar arquivo
            Files.deleteIfExists(target);   // arquivo renomeado apagado

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

