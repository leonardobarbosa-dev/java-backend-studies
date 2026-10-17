package com.leonardobarbosa.javastudy.utils.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


class TreeFileVisitor extends SimpleFileVisitor<Path> {

    private int level = 0;

    private void printIdent() {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        printIdent();
        System.out.println("Directory: " + dir.getFileName());
        level++;

        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        printIdent();
        System.out.println("File: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        level--;
        return FileVisitResult.CONTINUE;
    }
}


public class SimpleFileVisitorExample {
    public static void main(String[] args) throws IOException {

        /*
        SimpleFileVisitor
        - usado pelo Files.walkFileTree()
        - percorre toda a árvore de arquivos e diretórios
        - explora a estrutura completa de todas as pastas do Path

        Métodos principais:

        - preVisitDirectory()   -> entra na pasta
        - visitFile()           -> encontra arquivo
        - postVisitDirectory()  -> termina pasta
         */

        Path dir = Paths.get("src/com/leonardobarbosa/javastudy/utils/date");
        System.out.println(dir.toAbsolutePath());

        Files.walkFileTree(dir, new TreeFileVisitor());

    }
}
