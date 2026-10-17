package com.leonardobarbosa.javastudy.utils.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PathMatcherExercise {

    public static void main(String[] args) throws IOException {

        /*
        PathMatcher

        - não procura arquivos sozinho
        - apenas compara Path com padrões

        Usado junto com:

        Files.walkFileTree()
        - percorre a estrutura

        SimpleFileVisitor
        - define quando e o que comparar

        Exemplo:

        glob:** /*.java
        - encontra todos os .java

        glob:** /test
        - encontra diretórios test
         */


        Path dir = Paths.get("src");

        PathMatcher matcherDir = FileSystems.getDefault().getPathMatcher("glob:**/*test");
        PathMatcher matcherClass = FileSystems.getDefault().getPathMatcher("glob:**/*.java");


        Files.walkFileTree(dir, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {

                if (matcherDir.matches(dir)) {
                    System.out.println("Directory found: " + dir);
                }
                return FileVisitResult.CONTINUE;
            }

        });

        Files.walkFileTree(dir, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

                if (matcherClass.matches(file)) {
                    System.out.println("Class found: " + file.getFileName());
                }

                return FileVisitResult.CONTINUE;
            }
        });

    }
}