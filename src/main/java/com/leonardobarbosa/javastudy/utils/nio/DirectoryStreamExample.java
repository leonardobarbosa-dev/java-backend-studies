package com.leonardobarbosa.javastudy.utils.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamExample {
    public static void main(String[] args) {

        /*
        DirectoryStream
        - percorre arquivos e diretórios
        - retorna Path de cada elemento

        -> deve ser fechado close() ou try-with-resources
         */

        Path dir = Paths.get("/home/leonardo/IdeaProjects/java-backend-studies");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

            for (Path path : stream) {
                System.out.println(path.getFileName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
