package com.leonardobarbosa.javastudy.utils.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.time.ZoneId;

public class FileAttributesExample {
    public static void main(String[] args) {

        /*
        File Attributes -> fornecem informações sobre arquivos e diretórios


        BasicFileAttributes
        - informações do arquivo em qualquer sistema
        - apenas consulta de informações

        BasicFileAttributeView
        - permite acessar e modificar atributos básicos
        - permite leitura e alteração

        DosFileAttributes
        - atributos específicos do Windows

        PosixFileAttributes
        - atributos Linux/Unix
         */

        Path directory = Paths.get("DirectoryNIO");
        Path file = Paths.get("DirectoryNIO/file.txt");

        try {

            // Criar diretórios e arquivos
            Files.createDirectories(directory);

            if (Files.notExists(file)) {
                Files.createFile(file);
            }

            // BasicFileAttributes -> consulta informações do arquivo
            BasicFileAttributes basic =  Files.readAttributes(file, BasicFileAttributes.class);

            System.out.println("\nConsulta antes da alteração");
            System.out.println("Tamanho: " + basic.size());
            System.out.println("Criado: " + basic.creationTime().toInstant().atZone(ZoneId.systemDefault()));
            System.out.println("Modificado: " + basic.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()));
            System.out.println("Ultimo acesso: " + basic.lastAccessTime().toInstant().atZone(ZoneId.systemDefault()));


            // Escrever no arquivo
            Files.writeString(file, "Estou estudando NIO em Java");

            // BasicFileAttributeView -> permite acessar e alterar os atributos
            BasicFileAttributeView basicView = Files.getFileAttributeView(file, BasicFileAttributeView.class);

            FileTime lastModified = FileTime.from(Instant.MAX);
            FileTime lastAccess = FileTime.from(Instant.MIN);
            FileTime creationTime = FileTime.from(Instant.parse("2000-01-01T00:00:00Z"));

            basicView.setTimes(lastModified,
                    lastAccess,
                    null);

            /*
            setTimes()

            ordem:
            1. última modificação
            2. último acesso
            3. criação

            Nem todos os sistemas permitem alterar
            a data de criação
             */

            BasicFileAttributes attributesUpdated = basicView.readAttributes();

            System.out.println("\nApós a modificação");
            System.out.println("Tamanho: " + attributesUpdated.size());
            System.out.println("Criado: " + attributesUpdated.creationTime().toInstant().atZone(ZoneId.systemDefault()));
            System.out.println("Modificado: " + attributesUpdated.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()));
            System.out.println("Ultimo acesso: " + attributesUpdated.lastAccessTime().toInstant().atZone(ZoneId.systemDefault()));

            // DosFileAttributes -> Windows
//            DosFileAttributes dosFile = Files.readAttributes(file, DosFileAttributes.class);

//            System.out.println("Oculto: " + dosFile.isHidden());

            // PosixFileAttributes -> Linux/Unix
            PosixFileAttributes posix = Files.readAttributes(file, PosixFileAttributes.class);

            System.out.println("\nDono: " + posix.owner());
            System.out.println("Permissões: " + posix.permissions());


        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        File Attributes
        -> Trabalham com metadados do arquivo,
        não com o conteúdo.

        Conteúdo:
        - Files.writeString()
        - Reader / Writer

        Metadados:
        - BasicFileAttributes
        - BasicFileAttributeView


        Path
        - representa o caminho

        Files
        - cria/acessa/manipula

        Attributes
        - lê informações do arquivo

        AttributeView
        - acessa e altera atributos

        Reader/Writer
        - trabalha com o conteúdo
         */

    }
}
